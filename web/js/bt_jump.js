function returnTicket(value) {
    var myFrame = parent.document.getElementsByName('frame-content')[0];
    myFrame.src = "content/LoadSelNowServlet?bookID=" + value;
}

function deleteTicket(value) {
    var myFrame = parent.document.getElementsByName('frame-content')[0];
    myFrame.src = "content/LoadSelLastServlet?bookID=" + value;
}

function reUserLogin() {
    var myFrame = parent.document.getElementsByName('frame-content')[0];
    myFrame.src = "content/ReLoginServlet";
}