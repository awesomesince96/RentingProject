import 'package:flutter/material.dart';

class AuthPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _AuthPage();
  }
}

class _AuthPage extends State<AuthPage> {
  String _emailValue;
  String _passwordValue;
  bool _acceptTerms = false;

  DecorationImage _buildBackgroundImage() {
    return DecorationImage(
        fit: BoxFit.cover,
        colorFilter:
            ColorFilter.mode(Colors.black.withOpacity(0.3), BlendMode.dstATop),
        image: AssetImage('assets/background.jpg'));
  }

  Widget _buildEmailTextField() {
    return TextField(
      decoration: InputDecoration(
          labelText: 'E-mail', filled: true, fillColor: Colors.white),
      onChanged: (String value) {
        setState(() {
          _emailValue = value;
        });
      },
    );
  }

  Widget _buildPasswordTextField() {
    return TextField(
      maxLines: 4,
      decoration: InputDecoration(
          labelText: 'Password', filled: true, fillColor: Colors.white),
      onChanged: (String value) {
        setState(() {
          _passwordValue = value;
        });
      },
    );
  }

  Widget _buildAcceptSwitch() {
    return SwitchListTile(
        value: _acceptTerms,
        onChanged: (bool value) {
          setState(() {
            _acceptTerms = value;
          });
        },
        title: Text('Accept Terms: '));
  }

  void _submitForm() {
    final Map<String, dynamic> credential = {
      'email': _emailValue,
      'password': _passwordValue,
      'image': 'assets/material.png'
    };
    Navigator.pushReplacementNamed(context, '/products');
  }

  @override
  Widget build(BuildContext context) {
    final double deviceWidth = MediaQuery.of(context).size.width;
    final double targetWidth = deviceWidth > 550.0 ? 500.0 : deviceWidth * 0.95;
    return Scaffold(
      appBar: AppBar(
        title: Text('Login'),
      ),
      body: Container(
        decoration: BoxDecoration(image: _buildBackgroundImage()),
        padding: EdgeInsets.all(10.0),
        child: Center(
          child: SingleChildScrollView(
            child: Container(
              width: targetWidth,
              child: Column(
                children: <Widget>[
                  _buildEmailTextField(),
                  SizedBox(height: 10.0),
                  _buildPasswordTextField(),
                  _buildAcceptSwitch(),
                  SizedBox(height: 10.0),
                  RaisedButton(
                    child: Text('Login'),
                    color: Theme.of(context).accentColor,
                    textColor: Colors.white,
                    onPressed: _submitForm,
                  )
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
