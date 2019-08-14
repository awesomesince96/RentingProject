import 'package:flutter/material.dart';
import '../widgets/helpers/ensure_visible.dart';

class ProductEditPage extends StatefulWidget {
  final Function addProduct;
  final Function updateProduct;
  final Map<String, dynamic> product;
  final int productIndex;

  ProductEditPage(
      {this.addProduct, this.updateProduct, this.product, this.productIndex});

  @override
  State<StatefulWidget> createState() {
    return _ProductEditPage();
  }
}

class _ProductEditPage extends State<ProductEditPage> {
  final Map<String, dynamic> _formData = {
    'title': null,
    'description': null,
    'price': null,
    'image': 'assets/material.png'
  };

  // String _titleValue = '';
  // String _descriptionValue = '';
  // double _priceValue;
  // bool _acceptTerms = false;
  final GlobalKey<FormState> _formkey = GlobalKey<FormState>();

  Widget _buildPageContent(context) {
    final double deviceWidth = MediaQuery.of(context).size.width;
    final double targetWidth = deviceWidth > 550.0 ? 500.0 : deviceWidth * 0.95;
    final double targetPadding = deviceWidth - targetWidth;
    final _titleFocusNode = FocusNode();
    final _descriptionFocusNode = FocusNode();
    final _priceFocusNode = FocusNode();
    return GestureDetector(
      onTap: () {
        FocusScope.of(context).requestFocus(FocusNode());
      },
      child: Container(
        margin: EdgeInsets.all(10.0),
        child: Form(
          
          key: _formkey,
          child: ListView(
            padding: EdgeInsets.symmetric(horizontal: targetPadding / 2),
            children: <Widget>[
              EnsureVisibleWhenFocused(
                  focusNode: _titleFocusNode,
                  child: TextFormField(
                      focusNode: _titleFocusNode,
                      initialValue: widget.product == null
                          ? ''
                          : widget.product['title'].toString(),
                      decoration: InputDecoration(labelText: 'Product Title'),
                      validator: (String value) {
                        // if(value.trim().length <= 0){
                        if (value.isEmpty || value.length < 5) {
                          return 'Title is required and should be 5+ characters long';
                        }
                      },
                      onSaved: (String value) {
                        _formData['title'] = value;
                      })),
              EnsureVisibleWhenFocused(
                  focusNode: _descriptionFocusNode,
                  child: TextFormField(
                    focusNode: _descriptionFocusNode,
                    initialValue: widget.product == null
                        ? ''
                        : widget.product['description'].toString(),
                    maxLines: 4,
                    validator: (String value) {
                      if (value.isEmpty || value.length < 10) {
                        return 'Description is required and should be 5+ characters long';
                      }
                    },
                    decoration:
                        InputDecoration(labelText: 'Product Description'),
                    onSaved: (String value) {
                      _formData['description'] = value;
                    },
                  )),
              EnsureVisibleWhenFocused(
                  focusNode: _priceFocusNode,
                  child: TextFormField(
                    focusNode: _priceFocusNode,
                    initialValue: widget.product == null
                        ? ''
                        : widget.product['price'].toString(),
                    keyboardType: TextInputType.number,
                    decoration: InputDecoration(labelText: 'Price'),
                    validator: (String value) {
                      if (value.isEmpty ||
                          !RegExp(r'^(?:[1:9]\d*|0)?(?:\.\d+)?$')
                              .hasMatch(value)) {
                        return 'Price is required and should be a number';
                      }
                    },
                    onSaved: (String value) {
                      _formData['price'] = double.parse(value);
                    },
                  )),
              SizedBox(
                height: 10.0,
              ),
              RaisedButton(
                child: Text('Save'),
                color: Theme.of(context).accentColor,
                textColor: Colors.white,
                onPressed: _buildSubmitForm,
              ),
              GestureDetector(
                onTap: _buildSubmitForm,
                child: Container(
                  color: Colors.green,
                  padding: EdgeInsets.all(5.0),
                  child: Text('My Button'),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }

  void _buildSubmitForm() {
    if (!_formkey.currentState.validate()) {
      return;
    }
    _formkey.currentState.save(); // form all onSaved is called
    if (widget.product == null) {
      widget.addProduct(_formData);
    } else {
      widget.updateProduct(widget.productIndex, _formData);
    }
    // final Map<String, dynamic> product = {
    //   'title': _titleValue,
    //   'description': _descriptionValue,
    //   'price': _priceValue,
    //   'image': 'assets/material.png'
    // };

    Navigator.pushReplacementNamed(context, '/products');
  }

  @override
  Widget build(BuildContext context) {
    final Widget pageContent = _buildPageContent(context);
    return widget.product == null
        ? pageContent
        : Scaffold(
            appBar: AppBar(
              title: Text('Edit Product'),
            ),
            body: pageContent,
          );
  }
}

//Manullly make a button

// Center(
//       child: RaisedButton(
//         child: Text('Save'),
//         onPressed: () {
//           showModalBottomSheet(
//               context: context,
//               builder: (BuildContext context) {
//                 return Center(
//                   child: Text('This is Modal'),
//                 );
//               });
//         },
//       ),
//     );
