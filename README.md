# CycleCare

CycleCare is a Java console-based menstrual cycle and personal wellness management system. It helps users organize their profile, cycle records, symptoms, basic cycle insights, and general food and self-care recommendations.

## Features

- Create and view a personal profile
- Add and view cycle records
- Calculate the estimated next period
- Add and view symptom entries
- Display food and self-care recommendations
- Calculate the average cycle length
- Display basic cycle insights
- Validate incorrect inputs
- Use object-oriented programming concepts

## OOP Concepts Used

The application uses classes, objects, constructors, private fields, getters, setters, methods, ArrayList, loops, conditions, interfaces, abstraction, inheritance, method overriding, `super`, and polymorphism.

## Java Files

- `CycleCare.java` controls the main menu and program flow.
- `UserProfile.java` stores the user's profile information.
- `CycleRecord.java` stores cycle dates and calculates the estimated next period.
- `SymptomEntry.java` stores symptoms, mood, severity, and energy level.
- `Displayable.java` provides a common display method.
- `Recommendation.java` serves as the abstract parent class.
- `FoodRecommendation.java` provides food and hydration suggestions.
- `SelfCareRecommendation.java` provides self-care suggestions.
- `CycleAnalyzer.java` calculates basic cycle insights.

## How to Run

1. Open NetBeans.
2. Open the CycleCare project.
3. Make sure all Java files are inside the `cyclecare` package.
4. Run the `CycleCare.java` file.
5. Enter the requested information.
6. Choose an option from the main menu.
7. Select option `0` to exit.

## Main Menu

1. View My Profile  
2. Add Cycle Record  
3. View Cycle Records  
4. Add Symptom Entry  
5. View Symptom Entries  
6. Get Personalized Recommendations  
7. View Cycle Insights  
0. Exit  

## Limitations

The program is console-based and stores information only while it is running. It does not use a database, login system, online storage, notifications, or medical diagnosis. The cycle calculations and recommendations are general estimates only.

