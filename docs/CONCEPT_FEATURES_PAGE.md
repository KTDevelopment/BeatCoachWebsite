# Konzept: Features-Seite (`FeaturesScreen`)

**Projekt:** BeatCoachWebsite (`/Users/kevin/Development/AndriodStudioProjects/BeatCoachWebsite`)  
**Zielbereich:** `composeApp/src/commonMain/kotlin/de/ktdevelopment/beatcoach/web/features/FeaturesScreen.kt`  
**Route:** `#features` (`AppDestination.Features`, bereits in `App.kt` verdrahtet)

## Ziel
Die Features-Seite vom Platzhalter „under construction“ zu einer klaren, responsiven Übersicht der tatsächlichen Nutzerfunktionen der BeatCoach-App ausbauen – konsistent mit dem bestehenden Stack (Kotlin Multiplatform, Compose Multiplatform Web/Wasm, Material3, Compose Resources, bestehendes `PageContainer`/Theme/Breakpoints).

## Inhaltliche Struktur
Die Inhalte bilden die **tatsächlichen App-Funktionen** ab (nutzerorientiert, marketing-tauglich, fachlich korrekt).

| Sektion | Kernbotschaft | Punkte (aus App) | Icon (LineAwesome) |
|---|---|---|---|
| Metronom | Präzises Timing, flexibel einstellbar | BPM, Start/Stop, Akzente, Subdivisions/Notenauswahl, Lautstärke je Note/Subdivision | `ClockSolid` / `VolumeUpSolid` |
| Songs & Parts | Proben strukturiert organisieren | Songs, Parts (Phrase, Accelerando, Ritardando), BPM/Takt/Counts, Parts/Part-Gruppen abspielen | `FileAudio` / `PuzzlePieceSolid` |
| Audio & Playback | Mit eigenem Material üben | Mehrere Audio-Tracks, Tempo/Geschwindigkeit, Loop, zu Part springen, Count-In | `MusicSolid` / `PlaySolid` |
| Dokumente & Noten | Alles zum Song an einem Ort | PDF-Import, Ordnerstruktur, integrierter PDF-Viewer, Drag & Drop | `FilePdfSolid` / `FolderSolid` |
| Übungen & Fortschritt | Gezielt besser werden | Silent Beat, Tempo Change, Song-/Part-Wiederholungen, „Passes“ tracken | `SyncSolid` / `ChartLineSolid` |
| MIDI & Einstellungen | An dein Setup anpassbar | Wiedergabe Audio/MIDI, MIDI-Geräteauswahl, Count-In, Tonhöhe/Pitch, Tutorials | `PlugSolid` / `CogSolid` |
| Import/Export | Daten mitnehmen | Export/Import von Songs inkl. Anhängen im `.beatcz`-Format | `FileImportSolid` / `FileExportSolid` |

**CTA:** Store-Links zu Google Play und Apple App Store (Wiederverwendung von `androidAppLink`/`iosAppLink` aus `skeleton/header/SocialLinks.kt`).

**Genauigkeit:** Keine nicht existierenden Funktionen behaupten; Premium-Grenzen ggf. neutral behandeln.

## UI / Seitenaufbau
Innerhalb von `PageContainer` (Footer/Abstände konsistent):
1. **Header:** Titel + kurzer Intro-Text.
2. **Responsives Feature-Grid:** Karten mit Icon, Titel, Bullet-Liste.
   - `Smartphone`: 1 Spalte; `Tablet`: 2; `Desktop`/`LargeDesktop`: 2–3 (max. Breite für Lesbarkeit).
   - Breakpoints: `deviceSize()` / `horizontalPagePadding()` (`theme/Breakpoints.kt`).
3. **CTA-Block** mit Store-Buttons.

Material3 (`Card`/`Surface`, `MaterialTheme.typography`), `cursorHand()` für klickbare Elemente, konsistente Abstände.

## Technisches Design
- **Komponenten (wartbar):**
  - `features/model/FeatureSection.kt` – deklaratives Modell (`icon`, `titleRes`, `bullets`).
  - `features/components/FeatureSectionCard.kt` – Darstellung.
  - `features/components/FeaturesGrid.kt` – responsives Layout (z. B. `FlowRow` mit Spaltenzahl nach `deviceSize()`).
  - `features/components/FeaturesCta.kt` – Store-CTA.
  - `FeaturesScreen.kt` – komponiert Header, Grid, CTA.
- **i18n:** Neue `pages__features__*`-Keys in `composeResources/values/strings.xml` und `values-de-rDE/strings.xml`.
- **Scrolling:** Langer Seiteninhalt muss scrollbar sein. `PageContainer` wird um vertikales Scrollen erweitert (globale, konsistente Lösung), ohne bestehende Seiten zu brechen.
- **Assets:** Phase 1 ohne neue Screenshots (geringer Wartungsaufwand), Icon-Cards.

## Umsetzungsplan
1. Strings (EN/DE) ergänzen.
2. `PageContainer` scrollfähig machen.
3. Modell + Komponenten + `FeaturesScreen` implementieren.
4. Responsives Verhalten prüfen; Build-Kompatibilität sicherstellen.

## Akzeptanzkriterien
- `#features` ohne „under construction“, mit strukturierten Sektionen.
- Kernbereiche abgedeckt und faktisch konsistent mit der App.
- Responsiv (Smartphone–Large Desktop), DE/EN gepflegt, Store-CTA vorhanden.
- Passt zu `BeatCoachTheme`/Material3 und bestehender Website.
