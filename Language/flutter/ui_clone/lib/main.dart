import 'package:flutter/material.dart';
import 'package:ui_clone/widgets/schedule_card.dart';

void main() {
  runApp(const App());
}

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: const Color(0xFF181818),
        body: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.symmetric(
              horizontal: 20,
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const SizedBox(
                  height: 80,
                ),
                const Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Icon(
                      Icons.account_circle,
                      size: 70,
                    ),
                    Icon(
                      Icons.add_sharp,
                      color: Colors.white,
                      size: 70,
                    )
                  ],
                ),
                const SizedBox(
                  height: 20,
                ),
                Text(
                  'MONDAY 16',
                  style: TextStyle(
                      fontSize: 18,
                      color: Colors.white.withOpacity(0.8),
                      fontWeight: FontWeight.w600),
                ),
                const SizedBox(
                  height: 5,
                ),
                const Row(
                  children: [
                    Text(
                      'TODAY',
                      style: TextStyle(
                        fontSize: 48,
                        fontWeight: FontWeight.w600,
                        color: Colors.white,
                      ),
                    ),
                    SizedBox(
                      width: 3,
                    ),
                    Text(
                      '●',
                      style: TextStyle(
                        fontSize: 12,
                        fontWeight: FontWeight.w400,
                        color: Color.fromARGB(255, 231, 54, 244),
                      ),
                    ),
                    SizedBox(
                      width: 3,
                    ),
                    Text(
                      '17',
                      style: TextStyle(
                        fontSize: 48,
                        fontWeight: FontWeight.w400,
                        color: Colors.grey,
                      ),
                    ),
                    SizedBox(
                      width: 25,
                    ),
                    Text(
                      '18',
                      style: TextStyle(
                        fontSize: 48,
                        fontWeight: FontWeight.w400,
                        color: Colors.grey,
                      ),
                    ),
                    SizedBox(
                      width: 25,
                    ),
                    Text(
                      '19',
                      style: TextStyle(
                        fontSize: 48,
                        fontWeight: FontWeight.w400,
                        color: Colors.grey,
                      ),
                    ),
                  ],
                ),
                const SizedBox(
                  height: 30,
                ),
                const ScheduleCard(
                    startHour: "11",
                    startMinute: "30",
                    endHour: "12",
                    endMinute: "20",
                    content: "DESIGN\nMEETING",
                    people: "ALEX    HELENA    NANA",
                    bgColor: Color(0xFFFEF754)),
                const SizedBox(
                  height: 10,
                ),
                const ScheduleCard(
                    startHour: "12",
                    startMinute: "35",
                    endHour: "14",
                    endMinute: "10",
                    content: "DAILY\nPROJECT",
                    people: "ME    RICHARD    CIRY    +4",
                    bgColor: Color(0xFF9C6BCE)),
                const SizedBox(
                  height: 10,
                ),
                const ScheduleCard(
                    startHour: "15",
                    startMinute: "00",
                    endHour: "16",
                    endMinute: "30",
                    content: "WEEKLY\nPLANNING",
                    people: "DEN    NANA    MARK",
                    bgColor: Color(0xFFBCEE4B)),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
