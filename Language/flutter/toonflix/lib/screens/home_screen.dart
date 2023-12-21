import 'dart:async';

import 'package:flutter/material.dart';
import 'package:carousel_slider/carousel_slider.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  static const defaultMinutes = 25;
  int chooseSeconds = defaultMinutes * 60;
  int totalSeconds = defaultMinutes * 60;
  bool isRunning = false;
  int totalPomodoros = 0;
  int goals = 0;
  late Timer timer;

  void checkPomodoro() {}

  void onTick(Timer timer) {
    if (totalSeconds == 0) {
      setState(() {
        if (totalPomodoros + 1 == 4) {
          totalPomodoros = 0;
          goals += 1;
        } else {
          totalPomodoros = totalPomodoros + 1;
        }
        isRunning = false;
        totalSeconds = chooseSeconds;
      });
      timer.cancel();
    } else {
      setState(() {
        totalSeconds = totalSeconds - 1;
      });
    }
  }

  void onStartPressed() {
    timer = Timer.periodic(
      const Duration(seconds: 1),
      onTick,
    );
    setState(() {
      isRunning = true;
    });
  }

  void onPausePressed() {
    timer.cancel();
    setState(() {
      isRunning = false;
    });
  }

  void onReset() {
    totalSeconds = chooseSeconds;
    setState(() {
      timer.cancel();
      isRunning = true;
      onPausePressed();
    });
  }

  void onSetTime() {
    setState(() {
      totalSeconds = chooseSeconds;
      timer.cancel();
      isRunning = true;
      onPausePressed();
    });
  }

  String format(int seconds) {
    var duration = Duration(seconds: seconds);
    return duration.toString().split(".").first.substring(2, 7);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      body: Column(
        children: [
          Flexible(
            flex: 1,
            child: Container(
              alignment: Alignment.centerLeft,
              child: Row(
                children: [
                  const SizedBox(
                    width: 30,
                  ),
                  Text(
                    "POMOTIMER",
                    style: TextStyle(
                      color: Theme.of(context).cardColor,
                      fontSize: 25,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ],
              ),
            ),
          ),
          Flexible(
            flex: 1,
            child: Container(
              alignment: Alignment.bottomCenter,
              child: Text(
                format(totalSeconds),
                style: TextStyle(
                  color: Theme.of(context).cardColor,
                  fontSize: 89,
                  fontWeight: FontWeight.w600,
                ),
              ),
            ),
          ),
          Flexible(
            flex: 3,
            child: Center(
              child: Column(
                children: [
                  CarouselSlider(
                    options: CarouselOptions(
                      height: 40.0,
                      initialPage: 2,
                    ),
                    items: [1, 15, 20, 25, 30, 35].map((i) {
                      return Builder(
                        builder: (BuildContext context) {
                          return Container(
                              width: MediaQuery.of(context).size.width * 0.15,
                              margin:
                                  const EdgeInsets.symmetric(horizontal: 10.0),
                              decoration: BoxDecoration(
                                  color: Theme.of(context).cardColor),
                              child: Center(
                                child: IconButton(
                                  onPressed: () => {
                                    chooseSeconds = i,
                                    onSetTime(),
                                  },
                                  icon: Text(
                                    '$i',
                                    style: TextStyle(
                                        fontSize: 20.0,
                                        color: Theme.of(context)
                                            .colorScheme
                                            .background,
                                        fontWeight: FontWeight.bold),
                                  ),
                                ),
                              ));
                        },
                      );
                    }).toList(),
                  ),
                  const SizedBox(
                    height: 20,
                  ),
                  IconButton(
                    iconSize: 120,
                    color: Theme.of(context).cardColor,
                    onPressed: isRunning ? onPausePressed : onStartPressed,
                    icon: Icon(isRunning
                        ? Icons.pause_circle_outline
                        : Icons.play_circle_outline),
                  ),
                  const SizedBox(
                    height: 10,
                  ),
                  IconButton(
                    icon: Icon(
                      Icons.settings_backup_restore_outlined,
                      color: Theme.of(context).cardColor,
                      size: 35,
                    ),
                    onPressed: onReset,
                  ),
                  Text(
                    "Reset",
                    style: TextStyle(
                      fontSize: 15,
                      color: Theme.of(context).cardColor,
                    ),
                  )
                ],
              ),
            ),
          ),
          Flexible(
            flex: 1,
            child: Row(
              children: [
                Expanded(
                  child: Container(
                    decoration: BoxDecoration(
                      color: Theme.of(context).cardColor,
                      borderRadius: BorderRadius.circular(50),
                    ),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Text(
                              '$totalPomodoros / 4',
                              style: TextStyle(
                                fontSize: 30,
                                fontWeight: FontWeight.w600,
                                color: Theme.of(context)
                                    .textTheme
                                    .displayLarge!
                                    .color,
                              ),
                            ),
                            Text(
                              'Round',
                              style: TextStyle(
                                fontSize: 30,
                                fontWeight: FontWeight.w600,
                                color: Theme.of(context)
                                    .textTheme
                                    .displayLarge!
                                    .color,
                              ),
                            ),
                          ],
                        ),
                        Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Text(
                              '$goals / 12',
                              style: TextStyle(
                                fontSize: 30,
                                fontWeight: FontWeight.w600,
                                color: Theme.of(context)
                                    .textTheme
                                    .displayLarge!
                                    .color,
                              ),
                            ),
                            Text(
                              'Goals',
                              style: TextStyle(
                                fontSize: 30,
                                fontWeight: FontWeight.w600,
                                color: Theme.of(context)
                                    .textTheme
                                    .displayLarge!
                                    .color,
                              ),
                            ),
                          ],
                        ),
                      ],
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
