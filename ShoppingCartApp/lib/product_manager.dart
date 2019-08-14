// import 'package:flutter/material.dart';

// import './products.dart';

// class ProductManager extends StatelessWidget {
//   final List<Map<String,dynamic>> products;

//   ProductManager(this.products);
 
//   @override
//   Widget build(BuildContext context) {
//     return Column(
//       children: [
//         Expanded(
//           child: Products(products),
//         )
//       ],
//     );
//   }
// }


//  // ProductManager(this.startingProduct);
//   ProductManager({this.startingProduct});

//   @override
//   State<StatefulWidget> createState() {
//     return _ProductManagerState();
//   }
// }

// class _ProductManagerState extends State<ProductManager> {
//   List<Map<String, String>> _products = [];


  // @override
  // void initState() {
  //   if (widget.startingProduct != null) {
  //     _products.add(widget.startingProduct);
  //   }
  //   super.initState();
  // }

  // @override
  // void didUpdateWidget(ProductManager oldWidget) {
  //   super.didUpdateWidget(oldWidget);
  // }


// class ProductControl extends StatelessWidget{

//   final Function addProduct;

//   ProductControl(this.addProduct);

//   @override
//   Widget build(BuildContext context) {
//     return RaisedButton(
//             color: Theme.of(context).accentColor,
//             onPressed: () {
//               addProduct({'title':'Chocolate','image':'assets/material.png'});
//             },
//             child: Text('Add Product'),
//           );
//   }
// }

  //  Container(
  //           margin: EdgeInsets.all(10.0), child: ProductControl(appProduct)),