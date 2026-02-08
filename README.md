# F1 Driver Performance Analytics (JAVA)

## 專案簡介
這是一個基於 Java 開發的 F1 賽車數據分析工具。 
透過封裝賽事歷史資料，利用 Stream API 進行邏輯運算。 
最終願景： 透過大數據建模，計算車手在不同賽道與環境下的「奪冠勝率」，
並作為分析車手潛力的核心指標。

## 目前學習目標
* Java 21 核心技術 : 熟練使用 Record、Stream API、Lambda 表達式與集合框架 (Map, Set, List)。
* 資料正規化（Normalization）： 實作 Driver 與 Team 的解耦，練習處理資料庫關聯邏輯。
* 軟體架構設計 : 落實職責分離 (Separation of Concerns)，確保 Repository、Service、View 各司其職。
* 工程化規範 : 熟悉 Maven 專案結構、堅持 Git 版本管理規範（Conventional Commits），維持乾淨的開發紀錄。

## 開發環境
* Language : Java 21（Open JDK）
* IDE : IntelliJ IDEA 2025
* Build Tool : Maven
* Version Control : Git

## 技術實現紀錄

### 1. 領域模型設計
* **Record 實體** : 包含`Driver`（車手）、`Team`（車隊）、`RaceResult`（賽事結果）、`RaceDetails`（賽道資訊）。
* **資料解耦** : 將車手、車隊、賽事結果、賽道資訊分離，分別透過`teamId`、`driverId`、`raceId` 進行關聯，模擬現實中車手跨季轉隊的動態與不同賽季的賽事順序變更。

### 2. 系統架構
* **Repository 層** `FileRepository` : 負責與外部資料（CSV）對接，實作資料封裝與基礎錯誤處理。
* **Service 層** `StatisticsService` : 負責接收 Repository 的原始數據所有業務邏輯運算，如過濾車隊、計算勝率、多重條件排序（隊伍 + 姓名）。
* **View 層** `ResultPrinter` : 負責控制台（Console）的格式化輸出，美化 UI 介面，與運算邏輯解耦。
* **Controller 層** `Application` : 負責流程控制。

## 專案結構
```
.
├── data
│   ├── driver_detail.csv   # 車手基礎資料
│   ├── team_detail.csv     # 車隊基礎資料 (New!)
│   ├── race_detail.csv     # 賽道基礎資料 (New!)
│   └── race_result.csv     # 賽事原始戰果 (New!)
├── src/main/java/com/f1project
│   ├── model/              # 資料模型 (Records)
│   ├── repository/         # 資料存取 (File I/O)
│   ├── service/            # 業務邏輯 (Stream Processing)
│   ├── view/               # 格式化輸出 (Printer)
│   └── Application.java    # 程式啟動入口
└── README.md
```

### 開發日誌
* **2026-01-29** : 建立 model package 並實作 Driver Record ; 手動建立 2024 年車手基礎資料集。
* **2026-01-31** : 建立 RaceResult Record 與賽事資料集；開發 Stream API邏輯，完成跨模型關聯運算與特定車隊車手站上頒獎台的機率統計。
* **2026-02-01** : **[架構重構]**  *引入 `StatisticsService` 與 `ResultPrinter` 實現職責分離。
  * 實作 `Comparator` 進行多欄位排序（Secondary Sorting）
  * 封裝統計結果至 DTO，最佳化程式碼重用性與系統彈性
* **2026-02-02** : 建立 FileRepository 類別，實作車手資料讀取，並處理可能異常。
* **2026-02-08** : **[重大更新-資料正規化]** 實作 Driver、Team、RaceResult、RaceDetails檔案分離。
* **2026-02-11** : [預計] 實作透過關聯id取得資料，並透過正規化後的資料計算勝率。
