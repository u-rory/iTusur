package com.example.gpo;

        import java.io.IOException;
        import java.io.InputStream;
        import java.lang.reflect.Field;
        import javax.microedition.khronos.egl.EGL10;
        import javax.microedition.khronos.egl.EGLConfig;
        import javax.microedition.khronos.egl.EGLDisplay;
        import javax.microedition.khronos.opengles.GL10;
        import android.app.Activity;
        import android.content.Context;
        import android.content.res.Resources;
        import android.graphics.Color;
        import android.opengl.GLSurfaceView;
        import android.os.Bundle;
        import android.view.Display;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.LinearLayout;

        import com.threed.jpct.Camera;
        import com.threed.jpct.FrameBuffer;
        import com.threed.jpct.Light;
        import com.threed.jpct.Loader;
        import com.threed.jpct.Logger;
        import com.threed.jpct.Object3D;
        import com.threed.jpct.RGBColor;
        import com.threed.jpct.SimpleVector;
        import com.threed.jpct.World;
        import com.threed.jpct.util.MemoryHelper;

public class MainActivity extends Activity {

    private static MainActivity master = null;

    private Context context;
    private GLSurfaceView mGLView;
    private MyRenderer renderer = null;
    private FrameBuffer fb = null;
    private World world = null;
    private RGBColor back = new RGBColor(237, 237, 237);

    private float touchTurn = 0;
    private float touchTurnUp = 0;

    private int btnPlusClicked = 0;
    private int btnMinusClicked = 0;

    private int btnFirstFloorClicked = 1;
    private int btnSecondFloorClicked = 0;

    private float xpos = -1;
    private float ypos = -1;

    private float pointerXpos = -1;
    private float pointerYpos = -1;

    private float distance = 0;

    private float scale = 0;

    private Object3D[] gkFirstFloor = null;
    private Object3D object3D = null;

    private Light sun = null;

    private Button btnPlus;
    private Button btnMinus;

    private Button btnFirstFloor;
    private Button btnSecondFloor;

    protected void onCreate(Bundle savedInstanceState) {

        if (master != null) {
            copy(master);
        }

        context = getApplicationContext();
        super.onCreate(savedInstanceState);
        mGLView = new GLSurfaceView(getApplication());

        mGLView.setEGLConfigChooser(new GLSurfaceView.EGLConfigChooser() {
            public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
                int[] attributes = new int[]{EGL10.EGL_DEPTH_SIZE, 16, EGL10.EGL_NONE};
                EGLConfig[] configs = new EGLConfig[1];
                int[] result = new int[1];
                egl.eglChooseConfig(display, attributes, configs, 1, result);
                return configs[0];
            }
        });

        renderer = new MyRenderer();
        mGLView.setRenderer(renderer);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();
        btnPlus = new Button(context);
        btnPlus.setX(width - 170);
        btnPlus.setY(height*0.1f);
        btnPlus.setBackground(getResources().getDrawable(R.drawable.btnplus));

        btnMinus = new Button(context);
        btnMinus.setX(width - 145);
        btnMinus.setY(height*0.19f);
        btnMinus.setBackground(getResources().getDrawable(R.drawable.btnminus));

        btnFirstFloor = new Button(context);
        btnFirstFloor.setX(width-170);
        btnFirstFloor.setY(height*0.50f);
        btnFirstFloor.setTextSize(20);
        btnFirstFloor.setText("1");
        btnFirstFloor.setBackgroundColor(Color.WHITE);
        btnFirstFloor.setTextColor(Color.rgb( 17, 71, 145));

        btnSecondFloor = new Button(context);
        btnSecondFloor.setX(width-170);
        btnSecondFloor.setY(height*0.60f);
        btnSecondFloor.setTextSize(20);
        btnSecondFloor.setText("2");
        btnSecondFloor.setBackgroundColor(Color.WHITE);
        btnSecondFloor.setTextColor(Color.rgb(17, 71, 145));

        setContentView(mGLView);
        addContentView(btnPlus, new ViewGroup.LayoutParams(150, 150
        ));
        addContentView(btnMinus, new ViewGroup.LayoutParams(
                100, 100
        ));
        addContentView(btnFirstFloor, new ViewGroup.LayoutParams(
                150, 150
        ));
        addContentView(btnSecondFloor, new ViewGroup.LayoutParams(
                150, 150
        ));
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlusClicked = 1;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMinusClicked = 1;
            }
        });

        btnFirstFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFirstFloorClicked = 1;
            }
        });

        btnSecondFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSecondFloorClicked = 1;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLView.onResume();
    }
    private void copy(Object src) {
        try {
            Field[] fs = src.getClass().getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                f.set(this, f.get(src));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean onTouchEvent(MotionEvent me) {

        int pointerIndex = me.getActionIndex();
        int pointerId = me.getPointerId(pointerIndex);
        int action = me.getActionMasked();

        if (action == MotionEvent.ACTION_DOWN) {
            xpos = me.getX();
            ypos = me.getY();
            return true;
        }
        if (action == MotionEvent.ACTION_UP) {
            xpos = -1;
            ypos = -1;
            touchTurn = 0;
            touchTurnUp = 0;
            return true;
        }

        if (action == MotionEvent.ACTION_MOVE) {
            float xd = me.getX() - xpos;
            float yd = me.getY() - ypos;

            xpos = me.getX();
            ypos = me.getY();

            touchTurn = xd / -100f;
            touchTurnUp = yd / -100f;

            float pointerXd = me.getX(pointerIndex) - pointerXpos;
            float pointerYd = me.getY(pointerIndex) - pointerYpos;

            pointerXpos = me.getX(pointerIndex);
            pointerYpos = me.getY(pointerIndex);

            float distanceChanged = (float) Math.sqrt(Math.pow((pointerXpos - xpos), 2.0f) + Math.pow((pointerYpos - ypos), 2.0f));

            if (distanceChanged > distance) {
                scale = distanceChanged - distance;
            } else scale = (distance - distanceChanged) * -1;

            return true;
        }

        if (action == MotionEvent.ACTION_POINTER_DOWN) {
            pointerXpos = me.getX(pointerIndex);
            pointerYpos = me.getY(pointerIndex);
            distance = (float) Math.sqrt(Math.pow((pointerXpos - xpos), 2.0f) + Math.pow((pointerYpos - ypos), 2.0f));
            return true;
        }

        if (action == MotionEvent.ACTION_POINTER_UP) {
            pointerXpos = -1;
            pointerYpos = -1;
            distance = 0;
            scale = 0;
            return true;
        }
        try {
            Thread.sleep(15);
        } catch (Exception e) {
        }
        return super.onTouchEvent(me);
    }

    class MyRenderer implements GLSurfaceView.Renderer {
        public MyRenderer() {
        }
        public void onSurfaceChanged(GL10 gl, int w, int h) {
            if (fb != null) {
                fb.dispose();
            }
            fb = new FrameBuffer(gl, w, h);

            if (master == null) {

                world = new World();
                world.setAmbientLight(100, 100, 100);

                sun = new Light(world);
                sun.setIntensity(250, 250, 250);

                InputStream objectStream = context.getResources().openRawResource(R.raw.gk1obj);
                InputStream mtlStream = context.getResources().openRawResource(R.raw.gk1mtl);


                gkFirstFloor = Loader.loadOBJ(objectStream, mtlStream, 1.0f);

                try {
                    objectStream.close();
                    mtlStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                object3D = Object3D.mergeAll(gkFirstFloor);
                object3D.rotateX(3.14159f);
                object3D.build();

                world.addObject(object3D);

                Camera cam = world.getCamera();
                cam.moveCamera(Camera.CAMERA_MOVEOUT, 30);
                cam.moveCamera(Camera.CAMERA_MOVELEFT, 33);
                cam.moveCamera(Camera.CAMERA_MOVEUP, 30);
                cam.lookAt(object3D.getTransformedCenter());

                SimpleVector sv = new SimpleVector();
                sv.set(object3D.getTransformedCenter());
                sv.y -= 100;
                sv.z -= 100;
                sun.setPosition(sv);
                MemoryHelper.compact();
                if (master == null) {
                    master = MainActivity.this;
                }
            }
        }

        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        }

        public void onDrawFrame(GL10 gl) {
            if (touchTurnUp != 0) {
                object3D.translate(0, 0, touchTurnUp * 1.5f);
                Camera cam = world.getCamera();
                SimpleVector simpleVector = object3D.getCenter();
                simpleVector.z += touchTurnUp * 1.5f;
                cam.lookAt(simpleVector);
                touchTurnUp = 0;
            }

            if (touchTurn != 0) {
                object3D.translate(touchTurn * -1.5f, 0, 0);
                Camera cam = world.getCamera();
                SimpleVector simpleVector = object3D.getCenter();
                simpleVector.x += touchTurn * -1.5f;
                cam.lookAt(simpleVector);
                touchTurn = 0;
            }

          /*  if (scale != 0) {
                Camera cam = world.getCamera();
                SimpleVector simpleVector = object3D.getCenter();
                cam.setPosition(cam.getPosition().x + ((simpleVector.x - cam.getPosition().x)) * scale *0.1f,
                        cam.getPosition().y + ((simpleVector.y - cam.getPosition().y)) * scale *0.1f,
                        cam.getPosition().z + ((simpleVector.z - cam.getPosition().z)) * scale *0.1f);
                scale = 0;
            }*/

            if (btnPlusClicked == 1) {
                Camera cam = world.getCamera();
                SimpleVector simpleVector = object3D.getCenter();
                cam.setPosition(cam.getPosition().x + ((simpleVector.x - cam.getPosition().x)) * 0.1f,
                        cam.getPosition().y + ((simpleVector.y - cam.getPosition().y)) * 0.1f,
                        cam.getPosition().z + ((simpleVector.z - cam.getPosition().z)) * 0.1f);
                btnPlusClicked = 0;
            }

            if (btnMinusClicked == 1) {
                Camera cam = world.getCamera();
                SimpleVector simpleVector = object3D.getCenter();
                cam.setPosition(cam.getPosition().x + ((simpleVector.x - cam.getPosition().x)) * -0.1f,
                        cam.getPosition().y + ((simpleVector.y - cam.getPosition().y)) * -0.1f,
                        cam.getPosition().z + ((simpleVector.z - cam.getPosition().z)) * -0.1f);
                btnMinusClicked = 0;
            }

            if (btnFirstFloorClicked == 1) {

                object3D.setVisibility(true);
                btnFirstFloorClicked = 0;
            }

            if (btnSecondFloorClicked == 1) {
                object3D.setVisibility(false);
                btnSecondFloorClicked = 0;
            }

            fb.clear(back);
            world.renderScene(fb);
            world.draw(fb);
            fb.display();
        }
    }
}