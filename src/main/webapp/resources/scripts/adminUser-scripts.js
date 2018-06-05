$(window).load(function() {
    $("#test-table").FullTable({
        "alwaysCreating":true,
        "fields": {
            "gender":{
                "options":[
                    {
                        "title":"Male",
                        "value":"xy"
                    },
                    {
                        "title":"Female",
                        "value":"xx"
                    }
                ],
                "mandatory":true,
                "placeholder":"Select one",
                "errors":{
                    "mandatory":"Gender name is mandatory"
                }
            },
            "firstname":{
                "mandatory":true,
                "errors":{
                    "mandatory":"First name is mandatory"
                }
            },
            "lastname":{
                "mandatory":true,
                "errors":{
                    "mandatory":"Last name is mandatory"
                }
            },
            "age":{
                "type":"integer",
                "mandatory":false,
                "validator":function(age) {
                    if (age >= 0) {
                        return true;
                    } else {
                        return false;
                    }
                },
                "errors":{
                    "type":"Age must be an integer number",
                    "mandatory":"Age is mandatory",
                    "validator":"Age cannot be negative"
                }
            },
            "height":{
                "type":"decimal",
                "mandatory":false,
                "validator":function(height) {
                    if ((height > 0.3) && (height <= 2.8)) {
                        return true;
                    } else {
                        return false;
                    }
                },
                "errors":{
                    "type":"Height must be a number",
                    "mandatory":"Height is mandatory",
                    "validator":"Height cannot be neither biggest than 2.8 nor lowest than 0.3"
                }
            },
            "description":{
                "mandatory":false
            }
        }
    });

    $("#test-table").FullTable("draw");

    $("#test-table").FullTable({

        // is editable
        "editable":true,

        // is filterable
        "filterable":true,

        // is sortable
        "orderable":true,

        // is selectable
        "selectable":false,

        // event handlers
        "on":{
            "update":function() {

            }
        }
    });

    $("#test-table").FullTable("getData");
});