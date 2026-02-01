# F1 Driver Performance Analytics (JAVA)

## 專案簡介
這是一個基於 Java 開發的 F1 賽車數據分析工具。
透過封裝賽事歷史資料，利用 Stream API 進行邏輯運算，
計算車手站上頒獎台的機率，並作為預測車手潛力的基礎。

## 目前學習目標
* Java 21 核心技術 : 熟練使用 Record、Stream API、Lambda 表達式與集合框架 (Map, Set, List)。
* 軟體架構設計 : 實作職責分離 (Separation of Concerns)，練習模組化開發。
* 工程化規範 : 熟悉 Maven 專案結構、Git 版本管理規範 (Conventional Commits)。

## 開發環境
* Language : Java 21 (Open JDK)
* IDE : IntelliJ IDEA 2025
* Build Tool : Maven
* Version Control : Git

## 技術實現紀錄

### 1. 領域模型設計
* **Driver Record** : 封裝車手基本資訊(ID, Name, Team)，作為系統核心實體。
* **RaceResult Record** : 儲存單場賽事結果，透過 driverId 與 Driver 進行關聯(Foreign Key概念)
* **DriverPodiumStats DTO** : 專門用於傳出統計結果的資料傳輸物件，確保資料在不同層級間傳遞時的型別安全。

### 2. 系統架構
* **Service 層** (StatisticsService) : 負責所有業務邏輯運算，如過濾車隊、計算勝率、多重條件排序(隊伍 + 姓名)。
* **View 層** (ResultPrinter) : 負責控制台 (Console) 的格式化輸出，美化 UI 介面，與運算邏輯解耦。
* **Controller 層** (Application) : 負責流程控制。

### 開發日誌
* **2026-01-29** : 建立 model package 並實作 Driver Record ; 手動建立 2024 年車手基礎資料集。
* **2026-01-31** : 建立 RaceResult Record 與賽事資料集；開發 Stream API邏輯，完成跨模型關聯運算與特定車隊車手站上頒獎台的機率統計。
* **2026-02-01** : **[架構重構]**  *引入 `StatisticsService` 與 `ResultPrinter` 實現職責分離。
  * 實作 `Comparator` 進行多欄位排序 (Secondary Sorting)
  * 封裝統計結果至 DTO，最佳化程式碼重用性與系統彈性
