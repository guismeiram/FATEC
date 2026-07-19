ng new ecommerce-frontend --routing --style=scss
npm install tailwindcss daisyui @angular/material

______________________________________________________________________

@NgModule({
  imports: [
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'products', component: ProductListComponent }
    ])
  ]
})
export class AppModule {}

______________________________________________________________________

<!-- product-list.component.html -->
<div class="grid grid-cols-1 md:grid-cols-3 gap-4">
  <div *ngFor="let product of products" class="card bg-base-100 shadow-xl">
    <img [src]="product.imageUrl" alt="Product">
    <div class="card-body">
      <h2 class="card-title">{{ product.name }}</h2>
      <p>{{ product.price | currency }}</p>
      <button (click)="addToCart(product)" class="btn btn-primary">Add to Cart</button>
    </div>
  </div>
</div>

______________________________________________________________________


