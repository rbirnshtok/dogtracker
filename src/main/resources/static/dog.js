
$(document).ready(function() {
    $.ajax({
       url: "http://localhost:8080/dogTracker/dogs?ownerid=10"
    }).then(function(data) {


        $("#addNewDog").css("background-color", "pink");
       var SetData = $("#dogsGrid");
          //var myDogs = JSON.parse(data);
        var myDogs = data;

        var countDogsLabel = document.createElement( "label" );
        $("label").text("You have " + myDogs.length + " dogs");
        $("body").append(countDogsLabel);
        alert("You have " + myDogs.length + " dogs!");

        var Data = "";
        var dogsGridHeader = "<tr class='table_header'>" +
            /*"<th>Dog Id</th>" +*/
            "<th>Dog Name</th>" +
            "<th>Breed</th>" +
            "<th>Age</th>" +
            "<th>Sex</th>" +
            "<th>Color</th>" +
            "<th>About My Dog</th>" +
            "<th>Is Active</th>" +
            "<th>Photo</th>" +
            "<th>Edit</th>" +
            "<th>Delete</th>" +
            "</tr>";
        if(myDogs.length > 0){
            Data = dogsGridHeader;
        }

         for (var i = 0; i < myDogs.length; i++) {
              Data = Data + "<tr class='row_" + myDogs[i].dogId + "'>" +
                 /*"<td>" + myDogs[i].dogId + "</td>" +*/
                 "<td>" + myDogs[i].dogName + "</td>" +
                 "<td>" + myDogs[i].breed + "</td>" +
                 "<td>" + myDogs[i].age + "</td>" +
                 "<td>" + myDogs[i].sex + "</td>" +
                 "<td>" + myDogs[i].color + "</td>" +
                 "<td>" + myDogs[i].aboutMyDog + "</td>" +
                 "<td>" + myDogs[i].active + "</td>" +
                  "<td>Some Photo</td>" +
                  "<td><button value='Edit'></button></td>" +
                  "<td><button value='Delete'></button></td>" +
                 "</tr>";

         }
        SetData.append(Data);

        $( "#addNewDog" ).click(function() {
            var newDogRow = "<tr>" +
                /*"<td><input/></td>" +*/
                "<td><input/></td>" +
                "<td><input/></td>" +
                "<td><input/></td>" +
                "<td><input/></td>" +
                "<td><input/></td>" +
                "<td><input/></td>" +
                "<td><input/></td>" +
                "<td><input type='file'/></td>" +
                "<td><button value='Edit'></button></td>" +
                "<td><button value='Delete'></button></td>" +
                "</tr>";
            $("#dogsGrid").append(newDogRow);
        });

    });
});

