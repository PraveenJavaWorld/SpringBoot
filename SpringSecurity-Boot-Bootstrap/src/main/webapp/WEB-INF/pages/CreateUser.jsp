<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link href="bootstrap/dist/css/bootstrap.css" rel="stylesheet">
        <link href="bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
        <link href="css/CreateUser.css" rel="stylesheet" >
    </head>
    <body>
        <div class="container-fluid m-3">
            <div class="container mb-5" id="heading">
                <h1>WELCOME TO E-BANKING SERVICES</h1>
            </div>
            <div class="w-50 container border border-3" id="div1">
                <form:form  method="POST" action="save" modelAttribute="cust">
                    <h4>Registration of Internet Banking</h4><br>
                    <table class="table table-borderless">
                        <tr>
                            <td><label class="control-label">Savings Account Number</label></td>
                            <td><form:input path="accno" class="form-control"/></td>
                        </tr>
                            <td><label class="control-label">Debit Card Number</label></td>
                            <td><form:input path="cardno" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><label class="control-label">Registered Mobile Number</label></td>
                            <td><form:input path="mobile" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><label class="control-label">Customer ID</label></td>
                            <td><form:input path="cid" class="form-control"/></td>
                        </tr>
                    </table>
                    <center>
                        <div class="mt-3 mb-3" id="links">
                            <input type="submit" value="I Agree" class="btn btn-outline-primary ms-5">
                            <a href="#" class="btn btn-outline-primary ms-5">I Disagree</a>
                        </div>
                    </center>
                </form:form>
            </div>
        </div>
        <script src="jquery/dist/jquery.js"></script>
        <script src="bootstrap/dist/js/bootstrap.bundle.js"></script>
    </body>
</html>