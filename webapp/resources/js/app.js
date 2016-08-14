$(document).ready(function () {
    $("#searchForm").submit(function (e) {
        window.location.href = window.location.origin + '/search?q=' + $(this).find('input').val();
        return false;
    });

    $("#menuButton").click(function (e) {
        $("#sidePanelContainer").show('slide', {direction: 'left'}, 500);

        var sideMenuTimeout = setTimeout(function () {
            $("#sidePanelContainer").hide('slide', {direction: 'left'}, 500);
        }, 3000);
    });
});