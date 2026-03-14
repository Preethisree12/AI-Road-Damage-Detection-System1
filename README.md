# AI Road Damage Detection System

This project detects potholes in road images using Java image processing.
The system analyzes road images and highlights damaged areas.

## Features
- Detects potholes in road images
- Marks damaged areas in red
- Generates a damage report
- Simple image processing using Java

## Technologies Used
- Java
- BufferedImage
- IntelliJ IDEA
- Image Processing

## Project Structure

AI-Road-Damage-Detection-System
│
├── images
│   ├── road_good.jpg
│   └── road_pothole.jpg
│
├── src
│   ├── Main.java
│   └── DamageDetector.java
│
├── detected_damage.jpg
└── report.txt

## How to Run

1. Open the project in IntelliJ IDEA
2. Run Main.java
3. Enter the image path when asked

Example:

images/road_pothole.jpg

## Output

If damage is detected:
⚠ Road Damage Detected

If road is good:
✅ Road is Good

## Future Improvements
- Detect multiple potholes
- Use AI / Machine Learning for better accuracy
- Connect system to city reporting systems