Feature: Kullanici olarak otel rezervasyonu olusturmak

  Scenario: Kullanici bir otel rezervasyonu olusturur ve rezervasyonu iptal eder
    Given Kullanici yeni bir rezervasyon olusturur
    And Kullanici rezervasyon icin gereken bilgileri girer
    When Kullanici otel rezervasyonunu tamamlar
    Then Rezervasyon basarili bir sekilde olusturuldu
    And Kullanici olusturulan rezervasyonu iptal eder