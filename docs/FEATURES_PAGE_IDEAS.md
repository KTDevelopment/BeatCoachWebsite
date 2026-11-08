# Ideen: Features-Seite – Stand & verbleibende Punkte

Bezug: `#features` (`composeApp/src/commonMain/kotlin/.../web/features/FeaturesScreen.kt`)

## Umgesetzt
- **Nutzen-Satz je Sektion**: `benefit` pro `FeatureSection` in den Cards.
- **Mini-FAQ**: 5 faktenbasierte Fragen/Antworten (eigene Audiodateien, PDFs/Noten, Timing-Übungen, MIDI, Übertrag via BeatCoach-Datei `.beatcz`).
- **„Was macht BeatCoach besonders?“**: 4 Highlight-Kacheln, faktenbasiert.
- **Interaktive Filter**: Chips *Alle / Organisieren / Üben / Wiedergabe / MIDI & Setup*; filtert Sektionen nach Tags (keine Auswahl = alle).
- **Feature-Details per Dialog**: Cards vergrößern sich beim Hover (Maus) und öffnen per Klick einen Dialog mit Details; der frühere „Details anzeigen/ausblenden“-Button ist entfernt (keine Höhenänderung im Grid). Detailinhalte weiterhin für **Songs & Parts** und **Übungen & Fortschritt**.
- **Sekundärer CTA**: „Tutorials ansehen“ (YouTube) zusätzlich zum Store-CTA.
- **Begriffsklarheit**: `.beatcz` als „BeatCoach-Datei (.beatcz)“ formuliert (DE/EN).
- **Barrierefreiheit (Basis)**: dekorative Icons mit `contentDescription = null` wo Titel/Label vorhanden; klickbare Elemente mit Text/Label.
- **i18n**: neue Texte in `values/strings.xml` und `values-de-rDE/strings.xml`.

## Offen (benötigt Assets, Verifikation oder größere Architektur)
- **Aktuelle App-Screenshots** pro Sektion oder 2–3 Key-Screens: größter Effekt für Glaubwürdigkeit. Nur mit gepflegten, aktuellen Bildern (`composeResources/drawable/`, `painterResource`, gute `contentDescription` DE/EN). *Nicht umgesetzt, da keine verifizierten Assets vorliegen.*
- **Demo-Material** (Video/GIF/Tutorial-Thumbnails): im `wasmJs`-Web je nach Embed-/Hosting-Ansatz separat prüfen. *Nicht umgesetzt.*
- **Social Proof**: Zitate, Pressestimmen oder verlässliche Store-Signale – **nur bei vorhandenen, verifizierten Angaben**. Keine erfundenen Inhalte. *Nicht umgesetzt.*
- **SEO/Crawlability**: Hash-Routing (`#features`) ist für Crawling eingeschränkt; größere Maßnahmen (Prerendering/Seitenstruktur) sind ein separates, architektonisches Thema. Seitentexte/Überschriften bleiben klar.
- **Kontrastprüfung**: finale Prüfung der Farben/Kontraste im `BeatCoachTheme` bei Bedarf im Design-Review.

## Mögliche nächste Feinschliffe (optional)
- Filter auf sehr kleinen Screens ggf. kompakter darstellen (z. B. Umbruch/Abstände optimieren) nach Sichtprüfung.
- Optional wieder eine kompakte Sektionsnavigation ergänzen, falls sich Nutzer auf langen Seiten Orientierung wünschen.
- Screenshots einplanen, sobald aktuelle App-Bilder verfügbar sind.
