$(document).ready(function() {
    $('#tablePanneau').DataTable({
        columnDefs: [ {
            targets: [ 0 ],
            orderData: [ 0, 1 ]
        }, {
            targets: [ 1 ],
            orderData: [ 1, 0 ]
        }, {
            targets: [ 4 ],
            orderData: [ 4, 0 ]
        } ]
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
