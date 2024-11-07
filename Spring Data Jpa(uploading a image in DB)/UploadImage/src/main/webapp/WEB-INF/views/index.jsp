<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Image Upload</title>
</head>
<body>
    <h2>Upload an Image</h2>
<form method="POST" action="/up" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="Image Name" required><br><br>
    <input type="file" name="image" required><br><br>
    <button type="submit">Upload</button>
</form>
</body>
</html>
