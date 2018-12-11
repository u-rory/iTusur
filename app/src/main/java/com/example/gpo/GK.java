package com.example.gpo;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.threed.jpct.Camera;
import com.threed.jpct.FrameBuffer;
import com.threed.jpct.Light;
import com.threed.jpct.Loader;
import com.threed.jpct.Logger;
import com.threed.jpct.Object3D;
import com.threed.jpct.RGBColor;
import com.threed.jpct.SimpleVector;
import com.threed.jpct.Texture;
import com.threed.jpct.TextureManager;
import com.threed.jpct.World;
import com.threed.jpct.util.BitmapHelper;
import com.threed.jpct.util.MemoryHelper;

public class GK extends Fragment {
    private static final String PREFS_FILE = "Account";
    private static final String PREF_FRAG = "Frag";
    SharedPreferences settings;
    View rootView;
    private Context context;
    private GLSurfaceView mGLView;
    //private MyRenderer renderer = null;
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

    private Object3D[] gkSecondFloor = null;
    private Object3D secondFloor = null;
    private int fps = 0;
    private Light sun = null;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnFirstFloor;
    private Button btnSecondFloor;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_gk, container, false);
       /* rootView.setOnTouchListener(new View.OnTouchListener() {
           public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    int pointerIndex = event.getActionIndex();
                    int pointerId = event.getPointerId(pointerIndex);
                    int action = event.getActionMasked();

                    if (action == MotionEvent.ACTION_DOWN) {
                        xpos = event.getX();
                        ypos = event.getY();
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
                        float xd = event.getX() - xpos;
                        float yd = event.getY() - ypos;

                        xpos = event.getX();
                        ypos = event.getY();

                        touchTurn = xd / -100f;
                        touchTurnUp = yd / -100f;

                        float pointerXd = event.getX(pointerIndex) - pointerXpos;
                        float pointerYd = event.getY(pointerIndex) - pointerYpos;

                        pointerXpos = event.getX(pointerIndex);
                        pointerYpos = event.getY(pointerIndex);

                        float distanceChanged = (float) Math.sqrt(Math.pow((pointerXpos - xpos), 2.0f) + Math.pow((pointerYpos - ypos), 2.0f));

                        if (distanceChanged > distance) {
                            scale = distanceChanged - distance;
                        } else scale = (distance - distanceChanged) * -1;

                        return true;
                    }

                    if (action == MotionEvent.ACTION_POINTER_DOWN) {
                        pointerXpos = event.getX(pointerIndex);
                        pointerYpos = event.getY(pointerIndex);
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
                        // No need for this...
                    }
                }
                return true;
            }
        });*/


        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_FRAG, "6");
        prefEditor.apply();

      //  GLSurfaceView mGLView =(GLSurfaceView)rootView.findViewById(R.id.surfaceView);
        /*mGLView.setEGLConfigChooser(new GLSurfaceView.EGLConfigChooser() {
            public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
                int[] attributes = new int[]{EGL10.EGL_DEPTH_SIZE, 16, EGL10.EGL_NONE};
                EGLConfig[] configs = new EGLConfig[1];
                int[] result = new int[1];
                egl.eglChooseConfig(display, attributes, configs, 1, result);
                return configs[0];
            }
        });*/
           // context = getContext();
           // renderer = new MyRenderer();

          //  mGLView.setRenderer(renderer);
        }

   /* class MyRenderer implements GLSurfaceView.Renderer {

        private long time = System.currentTimeMillis();

        public MyRenderer() {
        }

        public void onSurfaceChanged(GL10 gl, int w, int h) {
            if (fb != null) {
                fb.dispose();
            }
            fb = new FrameBuffer(gl, w, h);


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

               InputStream objectStreamSecondFloor = context.getResources().openRawResource(R.raw.gk1floorobj);
                mtlStream = context.getResources().openRawResource(R.raw.gk1mtl);

                gkSecondFloor = Loader.loadOBJ(objectStreamSecondFloor, mtlStream, 1.0f);

                try {
                    objectStreamSecondFloor.close();
                    mtlStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                secondFloor = Object3D.mergeAll(gkSecondFloor);
                secondFloor.rotateX(3.14159f);
                secondFloor.build();

                world.addObject(secondFloor);

                Camera cam = world.getCamera();
                cam.moveCamera(Camera.CAMERA_MOVEOUT, 30);
                cam.moveCamera(Camera.CAMERA_MOVELEFT, 50);
                cam.moveCamera(Camera.CAMERA_MOVEUP, 30);
                cam.lookAt(object3D.getTransformedCenter());

                SimpleVector sv = new SimpleVector();
                sv.set(object3D.getTransformedCenter());
                sv.y -= 100;
                sv.z -= 100;
                sun.setPosition(sv);
                MemoryHelper.compact();
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

            if (scale != 0) {
                Camera cam = world.getCamera();
                SimpleVector simpleVector = object3D.getCenter();
                cam.setPosition(cam.getPosition().x + ((simpleVector.x - cam.getPosition().x)) * scale *0.1f,
                        cam.getPosition().y + ((simpleVector.y - cam.getPosition().y)) * scale *0.1f,
                        cam.getPosition().z + ((simpleVector.z - cam.getPosition().z)) * scale *0.1f);
                scale = 0;
            }

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
                secondFloor.setVisibility(false);
                btnFirstFloorClicked = 0;
            }

            if (btnSecondFloorClicked == 1) {
                secondFloor.setVisibility(true);
                object3D.setVisibility(false);
                btnSecondFloorClicked = 0;
            }

            fb.clear(back);
            world.renderScene(fb);
            world.draw(fb);
            fb.display();

            if (System.currentTimeMillis() - time >= 1000) {
                Logger.log(fps + "fps");
                fps = 0;
                time = System.currentTimeMillis();
            }
            fps++;
        }
    }*/

}


