

$(document).ready(()=> {
    var csrftoken = $("meta[name='_csrf']").attr("content");
    var csrfheader = $("meta[name='_csrf_header']").attr("content");

    $('#panneau').DataTable({
        "order": [ 0, 'desc' ],
        pageLength : 5,
        lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'tous']],
        "columns": [
            {visible:false, searchable:false},
            { "width": "60%" },
            null,
            { "width": "20%" },
            null,
        ],
        "language": {
            "lengthMenu": "Montrer _MENU_ messages par page",
            "zeroRecords": "Aucun Message",
            "info": "Page _PAGE_ sur _PAGES_",
            "infoEmpty": "Aucune information disponible",
            "infoFiltered": "(filtré parmis _MAX_ messages)"
        },

    });

    let likebtns = $(".likebtn");
    likebtns.click(function(){
        let mId = parseInt($(this).prev().val().replace(/\s/g,''));
        console.log("trying to like message "+mId);
        likeAjax(mId);
    });

    function likeAjax(mId) {
        var data = {}
        data["id"] = mId;

        $.ajax({
            type : "POST",
            url : "/likeMessage",
            data : JSON.stringify(data),
            dataType : 'json',
            timeout : 100000,
            beforeSend :(xhr) => {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                // xhr.setRequestHeader(csrfheader,csrftoken);
            },
            success : (data) =>{
                console.log("SUCCESS : ", data);
                alert(data);
            },
            error : (e)=> {
                console.log("ERROR: ", e);
            },
            done : function(e) {
                alert("DONE : " + e.toString());
                console.log("DONE");
            }
        });
    }

});



