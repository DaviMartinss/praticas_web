const express = require ('express' )
const app = express ()
const port = 3000

app.use(express.json())
app.use(express.urlencoded({ extended: true }))
app.use(express.static('public'));
app.set('view engine', 'ejs');
app.set('views', './views');

//app.use(basicAuth({users: { 'admin': '12345' }, challenge: true}));


/*app.use(basicAuth( { authorizer : myAuthorizer } ))

function myAuthorizer (username, password) {
	const userMatches = basicAuth.safeCompare (username, 'customuser' )
	const passwordMatches = basicAuth.safeCompare (password,'custompassword' )
	return userMatches & passwordMatches
}

app.use(basicAuth({ authorizer: myAsyncAuthorizer, authorizeAsync: true,}))

function myAsyncAuthorizer(username, password, cb) {
	if (username.startsWith('A') & password.startsWith('secret'))
		return cb(null, true)
	else
		return cb(null, false)
}

app.use('/produto/*', basicAuth( { authorizer: myAuthorizerMongo, authorizeAsync: true , challenge:true} ));

function myAuthorizerMongo(username, password, cb) {
	
	console.log(database.getUsers(username, password).then(users => {
	return cb(null, users.length > 0);}));
}

app.get('/', (req, res) => {

	basic = Buffer.from(req.headers.authorization.split(' ')[1], 'base64').toString().split(':');
	username = basic[0];
	password = basic[1];
	console.log('Username: ' + username);
	console.log('Password: ' + password);

}*/



app.get('/', (req, res) => {
  res.render('produto', {title: 'Lab MPA', message:'Bem vindo ao Lab MPA'});
});

//------------------Produtos---------------



app.get('/produto-novo', (req, res) => {

  res.render('cadastrarProduto', {title: 'Lab MPA', 
								  message:'Bem vindo ao Lab MPA' 
								 });

});

app.post('/produto-salvar', (req, res) => {
  
  var produto = { id: 0 , 
                  name:req.body.name, 
                  categoria:req.body.categoria, 
                  preco:req.body.preco, 
                  descricao:req.body.descricao};
                  
  bdProduto.addProduto(produto);
  
  res.redirect('/produtos');

});

app.listen(port, () => {
console.log(`Example app listening on port ${port}`)
})