# F1 Driver Performance Analytics (JAVA)

## 專案簡介
這是一個基於 Java 開發的 F1 賽車數據分析工具。
目標是透過賽車的歷史資料，計算車手勝率並預測未來冠軍淺力。

## 目前學習目標
* 練習 Java 21 的基本語法與物件導向設計。
* 熟悉 Maven 專案管理與 Git 版本控制。
* 實作基礎演算法處理數據排序與過濾。

## 開發環境
* Language : Java 21
* IDE : IntelliJ IDEA Community Edition
* Build Tool : Maven

## 技術實現紀錄

### 1. 領域模型設計
* **Driver Class** : 封裝車手基本資訊，練習使用 Java Record 簡化程式碼。

### 開發日誌
* **2026-01-29** : 建立 model package 並實作 Driver Record ; 手動建立 2024 年車手資料集。
* **2026-01-31** : 建立 RaceResult 類別，手動建立 2024 賽事結果，將 Driver 結合 RaceResult 實作計算特定車隊車手站上頒獎台的機率。
* **2026-02-01** : （預計）將目前的方法改成可以重複使用的方法。
