$(document).ready(function() {

    $('#panneau').DataTable({
        "order": [ 0, 'desc' ],
        pageLength : 5,
        lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'tous']],
        "columns": [
            {visible:false, searchable:false},
            { "width": "60%" },
            null,
            { "width": "20%" },
        ],
        retrieve: true,
        "language": {
            "lengthMenu": "Montrer _MENU_ messages par page",
            "zeroRecords": "Aucun Message",
            "info": "Page _PAGE_ sur _PAGES_",
            "infoEmpty": "Aucune information disponible",
            "infoFiltered": "(filtré parmis _MAX_ messages)"
        },

    });

    $("input[type='password'][data-eye]").each(function(i) {
        let $this = $(this);

        $this.wrap($("<div/>", {
            style: 'position:relative'
        }));
        $this.css({
            paddingRight: 60
        });
        $this.after($("<div/>", {
            html: 'Show',
            class: 'btn btn-secondary btn-sm',
            id: 'passeye-toggle-'+i,
            style: 'position:absolute;right:10px;top:50%;transform:translate(0,-50%);padding: 2px 7px;font-size:12px;cursor:pointer;'
        }));
        $this.after($("<input/>", {
            type: 'hidden',
            id: 'passeye-' + i
        }));
        $this.on("keyup paste", function() {
            $("#passeye-"+i).val($(this).val());
        });
        $("#passeye-toggle-"+i).on("click", function() {
            if($this.hasClass("show")) {
                $this.attr('type', 'password');
                $this.removeClass("show");
                $(this).removeClass("btn-outline-secondary");
            }else{
                $this.attr('type', 'text');
                $this.val($("#passeye-"+i).val());
                $this.addClass("show");
                $(this).addClass("btn-outline-secondary");
            }
        });
    });
});
