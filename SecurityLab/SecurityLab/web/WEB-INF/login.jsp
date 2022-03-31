<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Notes</title>
        
        <!--Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <h1>Notes App</h1>
        <h2>Login</h2>
        <p>${message}</p>
        
        <form action="login" method="post">
                  <label for="email" >Email address: </label>
                  <input type="text" class="col-xs-3 " id="email" name="email" placeholder="enter email"><br />
    
      
                  <label for="password" >Password: </label>
                  <input type="password" class="col-xs-3" id="password" name="password" placeholder="enter password"><br />

            <input type="submit" value="Sign in" class="btn btn-secondary">
        </form>
    </body>
</html>
