$( function() {
    var eventsHandler;

    eventsHandler = {
        haltEventListeners: ['touchstart', 'touchend', 'touchmove', 'touchleave', 'touchcancel']
        , init: function(options) {
            var instance = options.instance
                , initialScale = 1
                , pannedX = 0
                , pannedY = 0

            // Init Hammer
            // Listen only for pointer and touch events
            this.hammer = Hammer(options.svgElement, {
                inputClass: Hammer.SUPPORT_POINTER_EVENTS ? Hammer.PointerEventInput : Hammer.TouchInput
            })

            // Enable pinch
            this.hammer.get('pinch').set({enable: true})

            // Handle double tap
            this.hammer.on('doubletap', function(ev){
                instance.zoomIn()
            })

            // Handle pan
            this.hammer.on('panstart panmove', function(ev){
                // On pan start reset panned variables
                if (ev.type === 'panstart') {
                    pannedX = 0
                    pannedY = 0
                }

                // Pan only the difference
                instance.panBy({x: ev.deltaX - pannedX, y: ev.deltaY - pannedY})
                pannedX = ev.deltaX
                pannedY = ev.deltaY
            })

            // Handle pinch
            this.hammer.on('pinchstart pinchmove', function(ev){
                // On pinch start remember initial zoom
                if (ev.type === 'pinchstart') {
                    initialScale = instance.getZoom()
                    instance.zoom(initialScale * ev.scale)
                }

                instance.zoom(initialScale * ev.scale)

            })

            // Prevent moving the page on some devices when panning over SVG
            options.svgElement.addEventListener('touchmove', function(e){ e.preventDefault(); });
        }

        , destroy: function(){
            this.hammer.destroy()
        }
    }

    // Expose to window namespace for testing purposes
    window.zoomgk1 = svgPanZoom('#gk1', {
        zoomEnabled: true
        , beforePan: function(oldP, newP) {return {y:true}}
        , fit: 1
        , center: 1
        , customEventsHandler: eventsHandler
    });

    window.zoomgk2 = svgPanZoom('#gk2', {
        zoomEnabled: true
        , fit: 1
        , center: 1
        , customEventsHandler: eventsHandler
    });

    window.zoomgk3 = svgPanZoom('#gk3', {
        zoomEnabled: true
        , fit: 1
        , center: 1
        , customEventsHandler: eventsHandler
    });

    window.zoomgk4 = svgPanZoom('#gk4', {
        zoomEnabled: true
        , fit: 1
        , center: 1
        , customEventsHandler: eventsHandler
    });

    zoomgk1.setOnZoom(function(level){
        if (level > 2) {
            $("#gk1 .st9").show(1000);
            $("#gk1 .st10").show(1000);
        }
        else {
            $("#gk1 .st9").hide(1000);
            $("#gk1 .st10").hide(1000);
        }
        zoomLevel = level;
        console.log("gk1 zoomLevel: " + zoomLevel + ", pan: x " + position.x + " y " + position.y);
    });

    zoomgk1.setOnPan(function(point){
        position = point;
        console.log("gk1 zoomLevel: " + zoomLevel + ", pan: x " + position.x + " y " + position.y);
    });

    zoomgk2.setOnZoom(function(level){
        if (level > 2) {
            $("#gk2 .st7").show(1000);
            $("#gk2 .st8").show(1000);
        }
        else {
            $("#gk2 .st7").hide(1000);
            $("#gk2 .st8").hide(1000);
        }
        zoomLevel = level;
        console.log("gk2 zoomLevel: " + zoomLevel + ", pan: x " + position.x + " y " + position.y);
    });

    zoomgk2.setOnPan(function(point){
        position = point;
        console.log("gk2 zoomLevel: " + zoomLevel + ", pan: x " + position.x + " y " + position.y);
    });

    zoomgk3.setOnZoom(function(level){
        if (level > 2) {
            $("#gk3 .st7").show(1000);
            $("#gk3 .st8").show(1000);
        }
        else {
            $("#gk3 .st7").hide(1000);
            $("#gk3 .st8").hide(1000);
        }
        zoomLevel = level;
    });

    zoomgk3.setOnPan(function(point){
        position = point;
    });

    zoomgk4.setOnZoom(function(level){
        if (level > 2) {
            $("#gk4 .st7").show(1000);
        }
        else {
            $("#gk4 .st7").hide(1000);
        }
        zoomLevel = level;
    });

    zoomgk4.setOnPan(function(point){
        position = point;
    });

});

var zoomLevel = 1;
var position = {x:289.25, y:0};

$(document).ready(function(){
    $( "#gk2" ).hide();
    $( "#gk3" ).hide();
    $( "#gk4" ).hide();
    $("#btn_floor1").attr("src", "svg/btn_floor1_clicked.svg");
});

var preBtn = 1;

function btn_floor1_click() {
    if (preBtn != 1) {
        $("#btn_floor" + preBtn).attr("src", "svg/btn_floor" + preBtn + ".svg");
        $("#btn_floor1").attr("src", "svg/btn_floor1_clicked.svg");
        $( "#gk" + preBtn ).fadeOut(1000);
        console.log("gk1 zoomLevel: " + zoomLevel + ", pan: x " + position.x + " y " + position.y);
        zoomgk1.zoom(zoomLevel);
        if (preBtn == 2)
            position = zoomgk2.getPan();
        else if (preBtn == 3)
            position = zoomgk3.getPan();
        else position = zoomgk4.getPan();
        zoomgk1.pan(position);
        $( "#gk1" ).fadeIn(1000);
        preBtn = 1;
    }
}

function btn_floor2_click() {
    if (preBtn != 2) {
        $("#btn_floor" + preBtn).attr("src", "svg/btn_floor" + preBtn + ".svg");
        $("#btn_floor2").attr("src", "svg/btn_floor2_clicked.svg");
        $( "#gk" + preBtn ).fadeOut(1000);
        console.log("gk2 zoomLevel: " + zoomLevel + ", pan: x " + position.x + " y " + position.y);
        zoomgk2.zoom(zoomLevel);
        if (preBtn == 1)
            position = zoomgk1.getPan();
        else if (preBtn == 3)
            position = zoomgk3.getPan();
        else position = zoomgk4.getPan();
        zoomgk2.pan(position);
        $( "#gk2" ).fadeIn(1000);
        preBtn = 2;
    }
}

function btn_floor3_click() {
    if (preBtn != 3) {
        $("#btn_floor" + preBtn).attr("src", "svg/btn_floor" + preBtn + ".svg");
        $("#btn_floor3").attr("src", "svg/btn_floor3_clicked.svg");
        $( "#gk" + preBtn ).fadeOut(1000);
        zoomgk3.zoom(zoomLevel);
        if (preBtn == 1)
            position = zoomgk1.getPan();
        else if (preBtn == 2)
            position = zoomgk2.getPan();
        else position = zoomgk4.getPan();
        zoomgk3.pan(position);
        $( "#gk3" ).fadeIn(1000);
        preBtn = 3;
    }
}

function btn_floor4_click() {
    if (preBtn != 4) {
        $("#btn_floor" + preBtn).attr("src", "svg/btn_floor" + preBtn + ".svg");
        $("#btn_floor4").attr("src", "svg/btn_floor4_clicked.svg");
        $( "#gk" + preBtn ).fadeOut(1000);
        zoomgk4.zoom(zoomLevel);
        if (preBtn == 1)
            position = zoomgk1.getPan();
        else if (preBtn == 2)
            position = zoomgk2.getPan();
        else position = zoomgk3.getPan();
        zoomgk4.pan(position);
        $( "#gk4" ).fadeIn(1000);
        preBtn = 4;
    }
}

function gk_plusScale() {
    if (preBtn == 1) {
        zoomgk1.zoomIn();
        zoomLevel = zoomgk1.getZoom();
    }
    else if (preBtn == 2) {
        zoomgk2.zoomIn();
        zoomLevel = zoomgk2.getZoom();
    }
    else if (preBtn == 3) {
        zoomgk3.zoomIn();
        zoomLevel = zoomgk3.getZoom();
    }
    else if (preBtn == 4) {
        zoomgk4.zoomIn();
        zoomLevel = zoomgk4.getZoom();
    }
}

function gk_minusScale() {
    if (preBtn == 1) {
        zoomgk1.zoomOut();
        zoomLevel = zoomgk1.getZoom();
    }
    else if (preBtn == 2) {
        zoomgk2.zoomOut();
        zoomLevel = zoomgk2.getZoom();
    }
    else if (preBtn == 3) {
        zoomgk3.zoomOut();
        zoomLevel = zoomgk3.getZoom();
    }
    else if (preBtn == 4) {
        zoomgk4.zoomOut();
        zoomLevel = zoomgk4.getZoom();
    }
}