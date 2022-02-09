import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:kalan_kibaru/config/config.dart';
import 'dart:convert';

// import 'ecole2.dart';
import 'orientations.dart';

class Ecoles1 extends StatefulWidget {
  final series1;

  Ecoles1({Key key, this.series1});

  @override
  _Ecoles1State createState() => _Ecoles1State();
}

class _Ecoles1State extends State<Ecoles1> {
  List ecole = [];
  List filterEdecole = [];
  var url = Uri.parse(urlSerie1);
  Future getEcole() async {
    final response = await http.post(url, body: {'series1': widget.series1});
    if (response.statusCode == 200) {
      var list = jsonDecode(response.body);
      setState(() {
        ecole = list;
      });
      return list;
    }
  }

  @override
  void initState() {
    super.initState();
    getEcole().then((data) {
      setState(() {
        ecole = filterEdecole = data;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.series1),
      ),
      body: Container(
        child: filterEdecole.length > 0
            ? GridView.builder(
                gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 3,
                  crossAxisSpacing: 1,
                  mainAxisSpacing: 2,
                  // mainAxisExtent: 200
                ),
                itemCount: filterEdecole.length,
                itemBuilder: (context, index) {
                  return GestureDetector(
                    onTap: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => Orientations(
                                  orientation: filterEdecole[index]
                                      ['nom_serie1'])));
                    },
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        Card(
                          child: Container(
                              width: 100,
                              height: 100,
                              child: Center(
                                  child: Text(
                                      filterEdecole[index]['nom_serie1']))),
                        )
                      ],
                    ),
                  );
                })
            : Center(
                child: CircularProgressIndicator(),
              ),
      ),
    );
  }
}
