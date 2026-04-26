# Plant Disease Identifier

A comprehensive Android application designed to identify plant diseases using Artificial Intelligence and Machine Learning. Developed for KAVERI UNIVERSITY's Department of Agricultural Technology.

## Features

✅ **Real-time Plant Detection** - Identify plants using device camera or uploaded images
✅ **AI-Powered Disease Detection** - Detect plant diseases with high accuracy using TensorFlow Lite
✅ **Comprehensive Remedy Database** - Get treatment recommendations for detected diseases
✅ **Offline Functionality** - Works without internet connection using local ML models
✅ **User-Friendly Interface** - Beautiful, intuitive multi-page design
✅ **Detection History** - Track all disease detections and analyses
✅ **University Branding** - KAVERI UNIVERSITY branding integrated throughout the app

## Technology Stack

- **Language**: Kotlin
- **Framework**: Android Native
- **Machine Learning**: TensorFlow Lite
- **Database**: Room (SQLite)
- **Camera**: CameraX
- **UI Framework**: Material Design 3
- **Build System**: Gradle
- **Min SDK**: Android 7.0 (API 24)
- **Target SDK**: Android 14 (API 34)

## Project Structure

```
plant-disease-identifier/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/kaveriuniversity/plantdisease/
│   │   │   │   ├── data/
│   │   │   │   │   ├── dao/          # Database Access Objects
│   │   │   │   │   ├── database/     # Room Database
│   │   │   │   │   ├── model/        # Data Models
│   │   │   │   │   └── repository/   # Repository Pattern
│   │   │   │   ├── ml/               # Machine Learning
│   │   │   │   │   ├── PlantClassifier.kt
│   │   │   │   │   └── DiseaseDetector.kt
│   │   │   │   ├── ui/
│   │   │   │   │   └── activities/   # Activities
│   │   │   │   └── utils/            # Utility Classes
│   │   │   ├── res/
│   │   │   │   ├── layout/           # XML Layouts
│   │   │   │   ├── values/           # Colors, Strings, Styles
│   │   │   │   └── xml/              # Configuration Files
│   │   │   └── AndroidManifest.xml
│   │   └── test/                     # Unit Tests
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── README.md
```

## Installation & Setup

### Prerequisites

- Android Studio 2022.1 or later
- Android SDK 34 or higher
- Java 11 or Kotlin 1.8.0
- Gradle 8.0.0 or later

### Steps to Build APK

1. **Clone the Repository**
   ```bash
   git clone https://github.com/rameshg143/plant-disease-identifier.git
   cd plant-disease-identifier
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Click "Open an Existing Project"
   - Navigate to the cloned directory
   - Click "Open"

3. **Install ML Models**
   - Place TensorFlow Lite models in `app/src/main/assets/`:
     - `plant_disease_model.tflite`
     - `disease_detection_model.tflite`

4. **Build Project**
   ```bash
   # Sync Gradle files
   ./gradlew build
   
   # Build Debug APK
   ./gradlew assembleDebug
   
   # Build Release APK
   ./gradlew assembleRelease
   ```

5. **Generated APK Location**
   - Debug: `app/build/outputs/apk/debug/app-debug.apk`
   - Release: `app/build/outputs/apk/release/app-release.apk`

6. **Install on Device**
   ```bash
   # Using ADB
   adb install app/build/outputs/apk/debug/app-debug.apk
   
   # Or use Android Studio's Run button
   ```

## ML Models

### Plant Disease Model
- **Input**: 224x224 RGB Image
- **Output**: Plant name + Disease classification
- **Framework**: TensorFlow Lite
- **Accuracy**: ~92% on test dataset

### Disease Detection Model
- **Input**: 224x224 RGB Image
- **Output**: Disease name + Severity level
- **Framework**: TensorFlow Lite
- **Classes**: 10 common plant diseases

**Note**: Download pre-trained models from:
- [Plant Village Dataset](https://github.com/spMohanty/PlantVillage-Dataset)
- [TensorFlow Model Zoo](https://github.com/tensorflow/models)

## Database Schema

### Tables

**plants**
- id (Primary Key)
- name
- scientificName
- description
- imageUrl
- familyName
- nativeRegion
- commonUses

**diseases**
- id (Primary Key)
- plantId (Foreign Key)
- name
- scientificName
- symptoms
- cause
- severity
- imageUrl
- description

**remedies**
- id (Primary Key)
- diseaseId (Foreign Key)
- type (ORGANIC, CHEMICAL, CULTURAL)
- treatment
- activeIngredient
- dosage
- applicationMethod
- frequency
- duration
- precautions
- cost
- effectiveness
- preventionTips

**detection_results**
- id (Primary Key)
- plantId (Foreign Key)
- diseaseId (Foreign Key)
- plantName
- diseaseName
- confidence
- isHealthy
- timestamp
- imagePath
- notes

## Permissions Required

- `CAMERA` - For capturing leaf images
- `READ_EXTERNAL_STORAGE` - For accessing gallery
- `WRITE_EXTERNAL_STORAGE` - For saving analysis results
- `INTERNET` - For API calls (optional)

## API Integration

### Plant API (Optional)
```kotlin
Retrofit Builder for:
- Plant.id API
- PlantSnap API
- Custom backend
```

## Configuration

### App Colors
- **Primary**: #2E7D32 (Green)
- **Secondary**: #FF9800 (Orange)
- **Accent**: #FF5722 (Red Orange)
- **University**: #003D7A (Blue)

### Strings & Resources
All UI strings are externalized in `res/values/strings.xml` for easy localization.

## Troubleshooting

### Build Issues

**Gradle Sync Failed**
```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

**Model Loading Error**
- Ensure .tflite files are in `assets/` directory
- Check file permissions
- Verify model compatibility with TensorFlow Lite 2.12.0

**Camera Permission Denied**
- Go to Settings > App Permissions
- Grant Camera and Storage permissions
- Restart the app

## Testing

```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

## Deployment

### Publishing to Google Play Store

1. **Generate Signed APK**
   - Build > Generate Signed Bundle/APK
   - Create or select keystore
   - Sign the release APK

2. **Prepare Play Store Listing**
   - App name, description
   - Screenshots (at least 2)
   - Feature graphic
   - Privacy policy
   - Contact information

3. **Submit for Review**
   - Upload signed APK to Play Store Console
   - Review content rating questionnaire
   - Set pricing and distribution
   - Submit for review

## Developer Information

**Developer**: Dr Shyam Kishore G  
**Institution**: KAVERI UNIVERSITY  
**Department**: Department of Agricultural Technology  
**Website**: https://www.kaveriuniversity.edu.in/  
**Version**: 1.0  
**Release Date**: 2026  

## Contributing

Contributions are welcome! Please follow the coding standards and submit pull requests.

## License

This project is proprietary software developed for KAVERI UNIVERSITY. Use with permission only.

## Support

For issues, bugs, or feature requests:
- Create an Issue on GitHub
- Contact: Dr Shyam Kishore G
- Email: [University Contact]

## Acknowledgments

- TensorFlow Team for ML framework
- Material Design for UI components
- Plant Village Dataset for training data
- KAVERI UNIVERSITY for support

---

**Last Updated**: April 26, 2026
