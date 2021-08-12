$(document).ready(function () {

    $('[name=detailsButton]').click(function (){
        window.open("/books/"+ this.id, "_self")
    });
});
