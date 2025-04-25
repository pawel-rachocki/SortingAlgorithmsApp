# 📊 Sorting Algorithm Visualizer (JavaFX)

An interactive visualization tool for classic sorting algorithms written in Java using JavaFX.  
It enables side-by-side comparison of **Bubble Sort**, **Insertion Sort**, **Merge Sort**, and **Quick Sort**.

## 🧠 Features

- Generates random arrays of integers (range: 5–1000)
- User can select array size: `10, 20, 30, 45, 50, 75, 100`
- Simultaneous visualization of all 4 algorithms
- Step-by-step animation of sorting
- Bars turn green upon completion of sorting
- Window resizing is disabled for a consistent layout

## 🖼️ User Interface

- Grid layout (2x2) — 4 visualization panels
- Labels above each panel indicating the algorithm used
- `Generate New Array` button to create random data
- `Start Sorting` button to begin the animations
- ComboBox to select array length

## 🚀 How to Run

### Requirements

- Java 17 or later
- JavaFX (e.g., OpenJFX) — added as a dependency or configured manually


🏗️ Project Structure

  sorting-visualizer/
  │
  ├── src/
  │   ├── gui/
  │   │   ├── SortingVisualizer.java      # Main JavaFX application class
  │   │   └── ArrayDisplay.java           # Custom canvas for drawing bars
  │   │
  │   └── sorting/
  │       ├── SortingAlgorithm.java       # Sorting algorithm interface
  │       ├── BubbleSort.java
  │       ├── InsertionSort.java
  │       ├── MergeSort.java
  │       └── QuickSort.java
  │
  └── README.md



