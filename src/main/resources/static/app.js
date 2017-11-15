$(function(){
    // Activate mobile nav toggle button
    $(".button-collapse").sideNav({edge: 'right'});
});

$("#mark").click(function () {
    if($("#mark").attr("class")=='mark favorite'){
        $("#mark").removeClass("mark favourite");
        $("#mark").addClass("unmark favourite");
    }
    else{
        $("#mark").removeClass("unmark favourite");
        $("#mark").addClass("mark favourite")
    }
});

