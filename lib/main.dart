import 'package:flutter/material.dart';
import 'package:yandex_mapkit/yandex_mapkit.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: MapScreen());
  }
}

class MapScreen extends StatelessWidget {
  final Point targetPoint = Point(
    latitude: 55.751244,
    longitude: 37.618423,
  ); // Москва

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Карта Яндекс')),
      body: YandexMap(
        onMapCreated: (controller) {
          controller.moveCamera(
            CameraUpdate.newCameraPosition(
              CameraPosition(target: targetPoint, zoom: 12),
            ),
          );
        },
        mapObjects: [
          PlacemarkMapObject(
            mapId: MapObjectId('placemark_1'),
            point: targetPoint,
            opacity: 1.0,
            direction: 0,
            isDraggable: false,
            onTap: (PlacemarkMapObject placemark, Point point) {
              print('Placemark tapped: ${placemark.mapId}');
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(content: Text('Вы нажали на метку: Москва')),
              );
            },
            icon: PlacemarkIcon.single(
              PlacemarkIconStyle(
                image: BitmapDescriptor.fromAssetImage('assets/mark.png'),
                scale: 0.19,
              ),
            ),
            text: PlacemarkText(
              text: 'Москва',
              style: PlacemarkTextStyle(
                size: 12.0,
                color: Colors.red,
                outlineColor: Colors.white,
                placement: TextStylePlacement.bottom,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
