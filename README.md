# Pico y Placa predictor Exercise

This program allows the user to determine if a vehicle has “Pico y Placa” by entering the license plate number, date, and time, all as a string. The following aspects were taken into account in the development of the exercise:

1. Only license plates that follow the format 'PVC-1234', 'PVC1234', 'PVC123' or 'PVC-123' are validated.
2. The date must have the format 'dd/MM/yyyy' to be considered valid.
3. The time must have the format 'HH:mm' to be considered valid. In addition, the 24-hour format is used.
4. The restricted hours for “Pico y Placa” are '07:00-09:30' in the morning and '16:00-19:30' in the afternoon.
5. The “Pico y Placa” is based on the last digit of the license plate number. The restricted numbers are as follows, depending on the day:

| Day        | Restricted numbers|
| -          | -                 |
| Monday     | 1,2               |
| Tuesday    | 3,4               |
| Wednesday  | 5,6               |
| Thursday   | 7,8               |
| Friday     | 9,0               |

## Table of Content

- [Technologies](https://github.com/MartinP44/pico-placa-exercise#technologies)
- [Project Structure](https://github.com/MartinP44/pico-placa-exercise#project-structure)
- [Usage](https://github.com/MartinP44/pico-placa-exercise#usage)
- [Tests](https://github.com/MartinP44/pico-placa-exercise#tests)

## Technologies

- Java language.
- MAVEN
- JFrame and JOptionPane - input and output data.
- JUnit Jupiter - testing tool.
- Github - version control.
- Apache NetBeans IDE 23

## Project Structure

The project is structured into six different packages. Their names and purposes are listed below:

1. **controller:** here are the classes to link the view and the program service.
2. **service:** contains the classes for implementing the program's business logic.
3. **view:** contains the program's user interface.
4. **util:** contains some utility classes for validating, parsing and constants.
5. **model:** contains the data objects with a simple logic.
6. **exception:** contains customized exceptions.

### 'controller' package

This package contains the *PredictorController* class. This class receives input from the user interface, performs validations using the *FormatValidatorUtil* class functions, then parses the date and time using the *DateTimeUtil* class and makes predictions using the *PicoPlacaServiceImpl*. Finally, it tells the view to display the prediction result.

### 'service' package

This package contains the logic to verify whether a vehicle can be driven based on the data entered. This package contains the following two elements:

1. **PicoPlacaService:** this is an interface to define what the service will do.
2. **impl/PicoPlacaServiceImpl:** this is the class where the logic is implemented to verify, based on the last digit of the license plate number, the date, and the time, whether the vehicle has “Pico y Placa”. It has three functions, the main one called ***checkPicoPlaca()*** with all the logic to determine whether or not it has “Pico y Placa”, this method returns a *PredictionResult* object; this is the one defined in the *PicoPlacaService* interface. There are also two auxiliary functions: the first, ***getRestrictedNumbers()***, obtains the restricted values according to the day and returns them as a List, and ***isRushHour()*** determines whether the time entered is within the rush hour ranges to return a boolean value.

### 'view' package

This package contains the *JFInputForm* class, which is basically the program's user interface for entering the necessary data.

<img width="732" height="376" alt="image" src="https://github.com/user-attachments/assets/efd44b07-5359-416c-b68f-d2e8a5dbcec8" />

In addition this class defines the ***showPredictionResult()*** method, which is called from the *PredictorController* to display the result of the “Pico y Placa” prediction using *JOptionPane*.

### 'util' package

This package has three utility classes, which are as follows:

1. ***DateTimeUtil:*** utility class for parsing the date and time from String type to LocalDate and LocalTime types, respectively.
2. ***FormatValidatorUtil:*** utility class for validating the format of the license plate, date, and time using regular expressions.
3. ***HolidayCalendar:*** utility class to define a set of fixed holiday dates. To check if a date corresponds to any of the dates in this class.

### 'model' package

This package contains 2 classes:

1. ***Plate:*** object to store the plate entered by the user.
2. ***PredictionResult:*** object to store the result of the "Pico y Placa" prediction.

### 'exception' package

This package contains 3 customized exceptions:

1. ***InvalidDateException:*** custom exception to handle date issues.
2. ***InvalidPlateException:*** custom exception to handle plate issues.
3. ***InvalidTimeException:*** custom exception to handle time issues.

## Usage

### Input

#### Case 1 input

***- Plate:*** PVC-0390
***- Date:*** 09/02/2026
***- Time:*** 08:30

<img width="740" height="310" alt="image" src="https://github.com/user-attachments/assets/8a813d1c-2d0a-48b6-a1da-c056ede9cd35" />

#### Case 2 input

***- Plate:*** XCB8901
***- Date:*** 09/02/2026
***- Time:*** 16:00

<img width="743" height="302" alt="image" src="https://github.com/user-attachments/assets/9d021fb0-1865-4a10-b38a-d0b30382a913" />

### Output

#### Case 1 output

It is expected that the car will have free circulation.

<img width="738" height="310" alt="image" src="https://github.com/user-attachments/assets/cafa115b-2b75-4ae9-8d6b-e22ccfde05c4" />

#### Case 2 output

It is expected that the car will have restricted circulation.

<img width="742" height="307" alt="image" src="https://github.com/user-attachments/assets/33366042-1dad-45d9-b7ec-dc883b750825" />

## Tests

For testing, there is a special test package with the respective tests for the FormatValidatorUtil and PicoPlacaServiceImpl classes.

<img width="930" height="625" alt="Screenshot 2026-02-09 031529" src="https://github.com/user-attachments/assets/99a34eba-d6c1-406a-ad09-00e61f8a68fa" />

<img width="1313" height="490" alt="Screenshot 2026-02-09 031545" src="https://github.com/user-attachments/assets/39eb7aff-6b3d-4cb0-9163-b0c7acc47e34" />

<img width="1311" height="421" alt="Screenshot 2026-02-09 031700" src="https://github.com/user-attachments/assets/d6565cb4-4fe3-4da0-aa3c-26df09f6ea62" />
