$(document).ready(function () {

    $('[name=booksButton]').click(function (){
        window.open("/books", "_self")
    });

    $('[name=authorsButton]').click(function (){
        window.open("/authors", "_self")
    });

    $('[name=detailsButtonB]').click(function (){
        window.open("/books/"+ this.id, "_self")
    });

    $('[name=detailsButtonA]').click(function (){
        window.open("/authors/"+ this.id, "_self")
    });

    $('[name=newBookButton]').click(function (){
        window.open("/books/new", "_self")
    });

    $('[name=newAuthorButton]').click(function (){
        window.open("/authors/new", "_self")
    });
});
