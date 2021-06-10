<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
    <div class="container">
           <h1 class='alert-success text-center'>Search By Id</h1>
        <div class="form-group">
            <label for="">Search By Id</label>
            <input class='form-control' type="text" placeholder="Type to Search">
        </div>
        <div class="form-group">
           <button class='btn btn-info'>Search</button>
        </div>
        <div>
            <table class='table table-bordered'>
                <thead class='table-dark'>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Cost</th>
                        <th>Remarks</th>
                        <th>Color</th>
                        <th>URL</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</body>
</html>