import 'package:flutter/material.dart';
import 'product_card.dart';

class Products extends StatelessWidget {
  final List<Map<String, dynamic>> products;
  // Products(this.products);
  // if want to make this optional []
  Products(this.products);

  Widget _buildProductItem(BuildContext context, int index) {
    return ProductCard(products[index], index);
  }

  Widget _buildProductList(BuildContext context) {
    Widget productCard;
    if (products.length > 0) {
      productCard = ListView.builder(
        itemBuilder: _buildProductItem,
        itemCount: products.length,
      );
    } else {
      productCard = Center(
        child: Text('No Products added'),
      );
    }
    return productCard;
  }

  @override
  Widget build(BuildContext context) {
    return _buildProductList(context);
  }
}

// return ListView(
//   children: products
//       .map((element) => Card(
//             child: Column(
//               children: <Widget>[
//                 Image.asset('assets/material.png'),
//                 Text(element)
//               ],
//             ),
//           ))
//       .toList(),
// );

// return products.length > 0 ? ListView.builder(
//   itemBuilder: _buildProductItem,
//   itemCount: products.length,
// ) : Center(child: Text('No Products added'),);

//if want to return null return Container();

//  FlatButton(
//                 child: Text('Details'),
//                 onPressed: () => Navigator.pushNamed<bool>(
//                     context, '/product/'+index.toString())
//                     .then((bool value) {
//                               if(value){
//                                 deleteProduct(index);
//                               }
//                             }),
//               )
