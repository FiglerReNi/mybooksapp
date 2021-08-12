$(document).ready(function () {

    $('[name=detailsButtonB]').click(function (){
        window.open("/books/"+ this.id, "_self")
    });

    $('[name=detailsButtonA]').click(function (){
        window.open("/authors/"+ this.id, "_self")
    });
});
