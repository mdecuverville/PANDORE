$(document).ready(()=> {
    $('#panneau').DataTable({
        "columns": [
            { "width": "60%" },
            null,
            null,
            null,
        ],
        "language": {
            "lengthMenu": "Montrer _MENU_ messages par page",
            "zeroRecords": "Aucun Message",
            "info": "Page _PAGE_ sur _PAGES_",
            "infoEmpty": "Aucune information disponible",
            "infoFiltered": "(filtré parmis _MAX_ messages)"
        }
    });

    let likebtns = $(".likebtn");
    likebtns.click(function(){
        let mId = $(this).prev().val().replace(/\s/g,'');
        console.log("trying to like message "+mId);
        likeMessage(mId);
    });


});


function likeMessage(id) {
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        url: "/likeMessage",
        data : {"id" : id},
        success: function (result) {
            alert(result.toString());
            return result;
        },
        fail: function (result) {
            alert(result.toString());
        }
    });
}


