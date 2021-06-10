function add(){
    let id = document.querySelector('#id').value;
    let name = document.querySelector('#name').value;
    let cost = document.querySelector('#cost').value;
    let desc = document.querySelector('#desc').value;
    let obj = {
        id, name, cost, desc
    }
    const promise = fetch('http://localhost:8080/addexpense',{
        method:'POST',
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
          },
        body:JSON.stringify(obj)
    });
    promise.then(response=>{
        response.text().then(data=>{
            document.querySelector('#message').innerText = data;
        }).catch(err=>{
            document.querySelector('#message').innerText= 'Error in Add ';
            console.log(err);
        }).catch(err=>{
            document.querySelector('#message').innerText= 'Server Response Error';
            console.log(err);
        })
    })
    console.log(obj);
}