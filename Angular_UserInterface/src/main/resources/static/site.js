function dodajRedPipip() {
    var table = document.getElementById("pipip");
    var row = table.insertRow(-1);
    row.innerHTML = "<td style=\"width:650px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:450px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:350px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:80px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:80px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td>";
}

function dodajRedPp() {
    var table = document.getElementById("pp");
    var row = table.insertRow(-1);
    row.innerHTML = "<td> <input placeholder=\"Ime i prezime\" class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td> <input placeholder=\"Ime i prezime\" class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td>";
}