$(document).ready(function () {

    $('[name=booksButton]').click(function () {
        window.open("/view/books", "_self")
    });

    $('[name=authorsButton]').click(function () {
        window.open("/view/authors", "_self")
    });

    $('[name=detailsButtonB]').click(function () {
        window.open("/view/books/" + this.id, "_self")
    });

    $('[name=detailsButtonA]').click(function () {
        window.open("/view/authors/" + this.id, "_self")
    });

    $('[name=newBookButton]').click(function () {
        window.open("/view/books/new", "_self")
    });

    $('[name=newAuthorButton]').click(function () {
        window.open("/view/authors/new", "_self")
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
        window.open("/view/authors/update/" + this.id, "_self")
    });

    $('[name=updateButtonB]').click(function () {
        window.open("/view/books/update/" + this.id, "_self")
    });

    $('#formAuthorUpdate').submit(function () {
        return false;
    });

    $('#formBookUpdate').submit(function () {
        return false;
    });

    $('[name=updateAuthorSubmit]').click(function () {
        if(fieldValidation($("#firstName").val()) && fieldValidation($("#lastName").val()) && fieldValidation($("#age").val())) {
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
                    $("body").html(data)
                }
            });
        }
    });

    $('[name=updateBookSubmit]').click(function () {
        if(fieldValidation($("#bookId").val()) && fieldValidation($("#title").val()) && fieldValidation($("#releaseDate").val())) {
            let author = $('#authorId').val().split("|");
            let authorData = {};
            let bookData = {};
            authorData["id"] = author[0];
            authorData["firstName"] = author[1];
            authorData["lastName"] = author[2];
            authorData["age"] = author[3];
            bookData["id"] = $("#bookId").val();
            bookData["title"] = $("#title").val();
            bookData["releaseDate"] = $("#releaseDate").val();
            bookData["author"] = authorData;
            $.ajax({
                type: "PUT",
                url: "../" + this.id,
                contentType: "application/json",
                data: JSON.stringify(bookData),
                success: function (data) {
                    $("body").html(data)
                }
            });
        }
    });

});

function fieldValidation(filed){
    return filed.length !== 0;
}
