$(document).ready(function () {

    $('[name=booksButton]').click(function () {
        window.open("/books", "_self")
    });

    $('[name=authorsButton]').click(function () {
        window.open("/authors", "_self")
    });

    $('[name=detailsButtonB]').click(function () {
        window.open("/books/" + this.id, "_self")
    });

    $('[name=detailsButtonA]').click(function () {
        window.open("/authors/" + this.id, "_self")
    });

    $('[name=newBookButton]').click(function () {
        window.open("/books/new", "_self")
    });

    $('[name=newAuthorButton]').click(function () {
        window.open("/authors/new", "_self")
    });

    $('[name=deleteButtonA]').click(function () {
        $.ajax({
            url: "authors/" + this.id,
            type: "DELETE",
            success: function () {
                window.open("/", "_self")
            }
        });
    });

    $('[name=deleteButtonB]').click(function () {
        $.ajax({
            url: "books/" + this.id,
            type: "DELETE",
            success: function () {
                window.open("/", "_self")
            }
        });
    });

    $('[name=updateButtonA]').click(function () {
        window.open("/authors/update/" + this.id, "_self")
    });

    $('#formAuthorUpdate').submit(function () {
        return false;
    });

    $('[name=updateAuthorSubmit]').click(function () {
        let data = {};
        data["id"] = $("#authorId").val();
        data["firstName"] = $("#firstName").val();
        data["lastName"] = $("#lastName").val();
        data["age"] = $("#age").val();
        $.ajax({
            type: "PUT",
            url: "../" + this.id,
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function () {
                window.open("/", "_self")
            }
        });
    });

});
