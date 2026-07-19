checkoutForm = new FormGroup({
  name: new FormControl('', Validators.required),
  cardNumber: new FormControl('', [Validators.required, Validators.pattern('[0-9]{16}')])
});


________________________________________________________________________


heroku create
git push heroku main
________________________________________________________________________

npm run build
vercel --prod

________________________________________________________________________

