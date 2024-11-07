<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/addAlien" method="post">
        ADD ALIEN :
        ENTER ID = <input type="text" name="id"><br>
        ENTER NAME = <input type="text" name="name"><br>
        <input type="submit">
    </form>
    <hr>
    <form action="/getAlien" method="get">
    ALIEN BY ID :
        ENTER ID = <input type="text" name="id"><br>
         <input type="submit">
    </form>
    <hr>
    <form action="/getAlienByName" method="get">
        ALIEN BY NAME :
        ENTER NAME = <input type="text" name="name"><br>
         <input type="submit">
    </form>
    <hr>
     <form action="/getAliens" method="get">
          <h1>GET ALL ALIENS : <h1>
          <input type="submit">
     </form>
     <hr>
       <form action="/deleteAlien" >
              DELETE ALIEN BY ID :
              ENTER ID = <input type="text" name="id"><br>
              <input type="submit">
       </form>
       <hr>
        <form action="/deleteByName" method="get">
                     DELETE ALIEN BY NAME :
                     ENTER name = <input type="text" name="name"><br>
                     <input type="submit">
        </form>
        <hr>
</body>
</html>