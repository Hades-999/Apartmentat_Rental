<%-- 
    Document   : results
    Created on : Nov 29, 2018, 9:09:23 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
        <style>
            div.one {
                border-style: solid;
                border-width: 2px;
            }
        </style>
    </head>
    <body>
        <div class="one">
            <h2><b><a href="#">${address}</a></b></h2><br>
            ${proptype}<br>
            ${apptype}<br>
            <b>Price:Rs</b>${price}
            <br>
        </div>
        <br>
    </body>
</html>
