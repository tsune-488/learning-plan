# 学習計画表アプリ
 https://learning-plan.onrender.com
 
<img width="1080" height="720" alt="アプリイメージ画" src="https://github.com/user-attachments/assets/aa78a6b4-e07f-4a85-b64a-4f77b278a1db" />
## 概要
学習計画表運用を効率化する、教員・生徒向けWebアプリです。

どこの中学校でも使われる「学習計画表」
どの学校に行っても同じなはずが、毎年学年会で議論になる。
そして、生徒はいつも手書きで書くのが大変！
また、先生も毎日チェックするのが大変！
そんな「学習計画表」をWebアプリにしました。

誰でも簡単に扱える**シンプル**でわかりやすい設計
紙と同じ**どの学校・どの学年でも共通して使っていた青い**学習計画表  
先生が**毎日約30分かかっていた確認作業を約5分に短縮できる設計**
としています。

---

## 使用技術
### バックエンド
- Java 21 (Eclipse Temurin)
- Spring Boot 3.3.5  
  - Spring MVC  
  - Spring Security  
- MyBatis  
  - mybatis-spring-boot-starter 3.0.3

### フロントエンド
- Thymeleaf
- HTML / CSS

### データベース
- MySQL

---

## 機能一覧
### 教員機能
- ログイン
- 学習計画期間（テスト期間）の登録
- 期間学習中の、日付ごとの学習計画・実施内容の確認
- 登録済み生徒名簿の確認
<img width="1280" height="720" alt="先生画面　学習計画チェック" src="https://github.com/user-attachments/assets/52b763d1-bae7-46ba-be7c-162d29de118b" />

### 生徒機能
- ログイン
- 学習計画・実施内容の入力
<img width="1280" height="720" alt="生徒画面　学習計画表" src="https://github.com/user-attachments/assets/af08d896-7ec7-496c-b188-45ae112ddb52" />

---
## 画面遷移図
<img width="1280" height="720" alt="画面遷移図" src="https://github.com/user-attachments/assets/04196377-a67f-4318-81b9-f25bf2fda4f0" />

---

## 工夫した点
- 教員用・生徒用で画面および機能を明確に分離
- テスト（学習計画期間）単位で生徒が紐づくデータ設計
- ログイン・新規登録時の入力バリデーション実装
- ICTが苦手な教員でも操作できる、シンプルなUI設計
- 教育現場での実運用を想定した画面遷移と操作回数の最小化

---

## ER図
<img width="711" height="385" alt="LearningPlan ER図" src="https://github.com/user-attachments/assets/0b863156-dfa2-44d2-a1c6-3ac370443504" />

本アプリでは、教員・生徒・学習計画期間（テスト）・学習記録を
それぞれ独立したエンティティとして設計しています。

学習記録テーブルを中心に、生徒とテストを紐づけることで、
「誰が・どの期間で・どの日に・何を計画し、何を実施したか」を
柔軟に管理できる構成としています。

## インフラ構成
- アプリ：Render（Spring Boot）
- DB：Railway（MySQL）

※ Render 無料プランを利用しているため、
15分間アクセスがない場合は自動的にスリープします。
初回アクセス時は起動に30秒ほどかかります。

