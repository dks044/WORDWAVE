<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/><title>WORDWAVE (구현중)</title><style>
/* cspell:disable-file */
/* webkit printing magic: print all background colors */
html {
	-webkit-print-color-adjust: exact;
}
* {
	box-sizing: border-box;
	-webkit-print-color-adjust: exact;
}

html,
body {
	margin: 0;
	padding: 0;
}
@media only screen {
	body {
		margin: 2em auto;
		max-width: 900px;
		color: rgb(55, 53, 47);
	}
}

body {
	line-height: 1.5;
	white-space: pre-wrap;
}

a,
a.visited {
	color: inherit;
	text-decoration: underline;
}

.pdf-relative-link-path {
	font-size: 80%;
	color: #444;
}

h1,
h2,
h3 {
	letter-spacing: -0.01em;
	line-height: 1.2;
	font-weight: 600;
	margin-bottom: 0;
}

.page-title {
	font-size: 2.5rem;
	font-weight: 700;
	margin-top: 0;
	margin-bottom: 0.75em;
}

h1 {
	font-size: 1.875rem;
	margin-top: 1.875rem;
}

h2 {
	font-size: 1.5rem;
	margin-top: 1.5rem;
}

h3 {
	font-size: 1.25rem;
	margin-top: 1.25rem;
}

.source {
	border: 1px solid #ddd;
	border-radius: 3px;
	padding: 1.5em;
	word-break: break-all;
}

.callout {
	border-radius: 3px;
	padding: 1rem;
}

figure {
	margin: 1.25em 0;
	page-break-inside: avoid;
}

figcaption {
	opacity: 0.5;
	font-size: 85%;
	margin-top: 0.5em;
}

mark {
	background-color: transparent;
}

.indented {
	padding-left: 1.5em;
}

hr {
	background: transparent;
	display: block;
	width: 100%;
	height: 1px;
	visibility: visible;
	border: none;
	border-bottom: 1px solid rgba(55, 53, 47, 0.09);
}

img {
	max-width: 100%;
}

@media only print {
	img {
		max-height: 100vh;
		object-fit: contain;
	}
}

@page {
	margin: 1in;
}

.collection-content {
	font-size: 0.875rem;
}

.column-list {
	display: flex;
	justify-content: space-between;
}

.column {
	padding: 0 1em;
}

.column:first-child {
	padding-left: 0;
}

.column:last-child {
	padding-right: 0;
}

.table_of_contents-item {
	display: block;
	font-size: 0.875rem;
	line-height: 1.3;
	padding: 0.125rem;
}

.table_of_contents-indent-1 {
	margin-left: 1.5rem;
}

.table_of_contents-indent-2 {
	margin-left: 3rem;
}

.table_of_contents-indent-3 {
	margin-left: 4.5rem;
}

.table_of_contents-link {
	text-decoration: none;
	opacity: 0.7;
	border-bottom: 1px solid rgba(55, 53, 47, 0.18);
}

table,
th,
td {
	border: 1px solid rgba(55, 53, 47, 0.09);
	border-collapse: collapse;
}

table {
	border-left: none;
	border-right: none;
}

th,
td {
	font-weight: normal;
	padding: 0.25em 0.5em;
	line-height: 1.5;
	min-height: 1.5em;
	text-align: left;
}

th {
	color: rgba(55, 53, 47, 0.6);
}

ol,
ul {
	margin: 0;
	margin-block-start: 0.6em;
	margin-block-end: 0.6em;
}

li > ol:first-child,
li > ul:first-child {
	margin-block-start: 0.6em;
}

ul > li {
	list-style: disc;
}

ul.to-do-list {
	padding-inline-start: 0;
}

ul.to-do-list > li {
	list-style: none;
}

.to-do-children-checked {
	text-decoration: line-through;
	opacity: 0.375;
}

ul.toggle > li {
	list-style: none;
}

ul {
	padding-inline-start: 1.7em;
}

ul > li {
	padding-left: 0.1em;
}

ol {
	padding-inline-start: 1.6em;
}

ol > li {
	padding-left: 0.2em;
}

.mono ol {
	padding-inline-start: 2em;
}

.mono ol > li {
	text-indent: -0.4em;
}

.toggle {
	padding-inline-start: 0em;
	list-style-type: none;
}

/* Indent toggle children */
.toggle > li > details {
	padding-left: 1.7em;
}

.toggle > li > details > summary {
	margin-left: -1.1em;
}

.selected-value {
	display: inline-block;
	padding: 0 0.5em;
	background: rgba(206, 205, 202, 0.5);
	border-radius: 3px;
	margin-right: 0.5em;
	margin-top: 0.3em;
	margin-bottom: 0.3em;
	white-space: nowrap;
}

.collection-title {
	display: inline-block;
	margin-right: 1em;
}

.page-description {
    margin-bottom: 2em;
}

.simple-table {
	margin-top: 1em;
	font-size: 0.875rem;
	empty-cells: show;
}
.simple-table td {
	height: 29px;
	min-width: 120px;
}

.simple-table th {
	height: 29px;
	min-width: 120px;
}

.simple-table-header-color {
	background: rgb(247, 246, 243);
	color: black;
}
.simple-table-header {
	font-weight: 500;
}

time {
	opacity: 0.5;
}

.icon {
	display: inline-block;
	max-width: 1.2em;
	max-height: 1.2em;
	text-decoration: none;
	vertical-align: text-bottom;
	margin-right: 0.5em;
}

img.icon {
	border-radius: 3px;
}

.user-icon {
	width: 1.5em;
	height: 1.5em;
	border-radius: 100%;
	margin-right: 0.5rem;
}

.user-icon-inner {
	font-size: 0.8em;
}

.text-icon {
	border: 1px solid #000;
	text-align: center;
}

.page-cover-image {
	display: block;
	object-fit: cover;
	width: 100%;
	max-height: 30vh;
}

.page-header-icon {
	font-size: 3rem;
	margin-bottom: 1rem;
}

.page-header-icon-with-cover {
	margin-top: -0.72em;
	margin-left: 0.07em;
}

.page-header-icon img {
	border-radius: 3px;
}

.link-to-page {
	margin: 1em 0;
	padding: 0;
	border: none;
	font-weight: 500;
}

p > .user {
	opacity: 0.5;
}

td > .user,
td > time {
	white-space: nowrap;
}

input[type="checkbox"] {
	transform: scale(1.5);
	margin-right: 0.6em;
	vertical-align: middle;
}

p {
	margin-top: 0.5em;
	margin-bottom: 0.5em;
}

.image {
	border: none;
	margin: 1.5em 0;
	padding: 0;
	border-radius: 0;
	text-align: center;
}

.code,
code {
	background: rgba(135, 131, 120, 0.15);
	border-radius: 3px;
	padding: 0.2em 0.4em;
	border-radius: 3px;
	font-size: 85%;
	tab-size: 2;
}

code {
	color: #eb5757;
}

.code {
	padding: 1.5em 1em;
}

.code-wrap {
	white-space: pre-wrap;
	word-break: break-all;
}

.code > code {
	background: none;
	padding: 0;
	font-size: 100%;
	color: inherit;
}

blockquote {
	font-size: 1.25em;
	margin: 1em 0;
	padding-left: 1em;
	border-left: 3px solid rgb(55, 53, 47);
}

.bookmark {
	text-decoration: none;
	max-height: 8em;
	padding: 0;
	display: flex;
	width: 100%;
	align-items: stretch;
}

.bookmark-title {
	font-size: 0.85em;
	overflow: hidden;
	text-overflow: ellipsis;
	height: 1.75em;
	white-space: nowrap;
}

.bookmark-text {
	display: flex;
	flex-direction: column;
}

.bookmark-info {
	flex: 4 1 180px;
	padding: 12px 14px 14px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.bookmark-image {
	width: 33%;
	flex: 1 1 180px;
	display: block;
	position: relative;
	object-fit: cover;
	border-radius: 1px;
}

.bookmark-description {
	color: rgba(55, 53, 47, 0.6);
	font-size: 0.75em;
	overflow: hidden;
	max-height: 4.5em;
	word-break: break-word;
}

.bookmark-href {
	font-size: 0.75em;
	margin-top: 0.25em;
}

.sans { font-family: ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol"; }
.code { font-family: "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace; }
.serif { font-family: Lyon-Text, Georgia, ui-serif, serif; }
.mono { font-family: iawriter-mono, Nitti, Menlo, Courier, monospace; }
.pdf .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK JP'; }
.pdf:lang(zh-CN) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK SC'; }
.pdf:lang(zh-TW) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK TC'; }
.pdf:lang(ko-KR) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK KR'; }
.pdf .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK JP'; }
.pdf:lang(zh-CN) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK SC'; }
.pdf:lang(zh-TW) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK TC'; }
.pdf:lang(ko-KR) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK KR'; }
.pdf .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK JP'; }
.pdf:lang(zh-CN) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK SC'; }
.pdf:lang(zh-TW) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK TC'; }
.pdf:lang(ko-KR) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK KR'; }
.pdf .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK JP'; }
.pdf:lang(zh-CN) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK SC'; }
.pdf:lang(zh-TW) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK TC'; }
.pdf:lang(ko-KR) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK KR'; }
.highlight-default {
	color: rgba(55, 53, 47, 1);
}
.highlight-gray {
	color: rgba(120, 119, 116, 1);
	fill: rgba(120, 119, 116, 1);
}
.highlight-brown {
	color: rgba(159, 107, 83, 1);
	fill: rgba(159, 107, 83, 1);
}
.highlight-orange {
	color: rgba(217, 115, 13, 1);
	fill: rgba(217, 115, 13, 1);
}
.highlight-yellow {
	color: rgba(203, 145, 47, 1);
	fill: rgba(203, 145, 47, 1);
}
.highlight-teal {
	color: rgba(68, 131, 97, 1);
	fill: rgba(68, 131, 97, 1);
}
.highlight-blue {
	color: rgba(51, 126, 169, 1);
	fill: rgba(51, 126, 169, 1);
}
.highlight-purple {
	color: rgba(144, 101, 176, 1);
	fill: rgba(144, 101, 176, 1);
}
.highlight-pink {
	color: rgba(193, 76, 138, 1);
	fill: rgba(193, 76, 138, 1);
}
.highlight-red {
	color: rgba(212, 76, 71, 1);
	fill: rgba(212, 76, 71, 1);
}
.highlight-gray_background {
	background: rgba(241, 241, 239, 1);
}
.highlight-brown_background {
	background: rgba(244, 238, 238, 1);
}
.highlight-orange_background {
	background: rgba(251, 236, 221, 1);
}
.highlight-yellow_background {
	background: rgba(251, 243, 219, 1);
}
.highlight-teal_background {
	background: rgba(237, 243, 236, 1);
}
.highlight-blue_background {
	background: rgba(231, 243, 248, 1);
}
.highlight-purple_background {
	background: rgba(244, 240, 247, 0.8);
}
.highlight-pink_background {
	background: rgba(249, 238, 243, 0.8);
}
.highlight-red_background {
	background: rgba(253, 235, 236, 1);
}
.block-color-default {
	color: inherit;
	fill: inherit;
}
.block-color-gray {
	color: rgba(120, 119, 116, 1);
	fill: rgba(120, 119, 116, 1);
}
.block-color-brown {
	color: rgba(159, 107, 83, 1);
	fill: rgba(159, 107, 83, 1);
}
.block-color-orange {
	color: rgba(217, 115, 13, 1);
	fill: rgba(217, 115, 13, 1);
}
.block-color-yellow {
	color: rgba(203, 145, 47, 1);
	fill: rgba(203, 145, 47, 1);
}
.block-color-teal {
	color: rgba(68, 131, 97, 1);
	fill: rgba(68, 131, 97, 1);
}
.block-color-blue {
	color: rgba(51, 126, 169, 1);
	fill: rgba(51, 126, 169, 1);
}
.block-color-purple {
	color: rgba(144, 101, 176, 1);
	fill: rgba(144, 101, 176, 1);
}
.block-color-pink {
	color: rgba(193, 76, 138, 1);
	fill: rgba(193, 76, 138, 1);
}
.block-color-red {
	color: rgba(212, 76, 71, 1);
	fill: rgba(212, 76, 71, 1);
}
.block-color-gray_background {
	background: rgba(241, 241, 239, 1);
}
.block-color-brown_background {
	background: rgba(244, 238, 238, 1);
}
.block-color-orange_background {
	background: rgba(251, 236, 221, 1);
}
.block-color-yellow_background {
	background: rgba(251, 243, 219, 1);
}
.block-color-teal_background {
	background: rgba(237, 243, 236, 1);
}
.block-color-blue_background {
	background: rgba(231, 243, 248, 1);
}
.block-color-purple_background {
	background: rgba(244, 240, 247, 0.8);
}
.block-color-pink_background {
	background: rgba(249, 238, 243, 0.8);
}
.block-color-red_background {
	background: rgba(253, 235, 236, 1);
}
.select-value-color-uiBlue { background-color: rgba(35, 131, 226, .07); }
.select-value-color-pink { background-color: rgba(245, 224, 233, 1); }
.select-value-color-purple { background-color: rgba(232, 222, 238, 1); }
.select-value-color-green { background-color: rgba(219, 237, 219, 1); }
.select-value-color-gray { background-color: rgba(227, 226, 224, 1); }
.select-value-color-translucentGray { background-color: rgba(255, 255, 255, 0.0375); }
.select-value-color-orange { background-color: rgba(250, 222, 201, 1); }
.select-value-color-brown { background-color: rgba(238, 224, 218, 1); }
.select-value-color-red { background-color: rgba(255, 226, 221, 1); }
.select-value-color-yellow { background-color: rgba(253, 236, 200, 1); }
.select-value-color-blue { background-color: rgba(211, 229, 239, 1); }
.select-value-color-pageGlass { background-color: undefined; }
.select-value-color-washGlass { background-color: undefined; }

.checkbox {
	display: inline-flex;
	vertical-align: text-bottom;
	width: 16;
	height: 16;
	background-size: 16px;
	margin-left: 2px;
	margin-right: 5px;
}

.checkbox-on {
	background-image: url("data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%0A%3Crect%20width%3D%2216%22%20height%3D%2216%22%20fill%3D%22%2358A9D7%22%2F%3E%0A%3Cpath%20d%3D%22M6.71429%2012.2852L14%204.9995L12.7143%203.71436L6.71429%209.71378L3.28571%206.2831L2%207.57092L6.71429%2012.2852Z%22%20fill%3D%22white%22%2F%3E%0A%3C%2Fsvg%3E");
}

.checkbox-off {
	background-image: url("data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%0A%3Crect%20x%3D%220.75%22%20y%3D%220.75%22%20width%3D%2214.5%22%20height%3D%2214.5%22%20fill%3D%22white%22%20stroke%3D%22%2336352F%22%20stroke-width%3D%221.5%22%2F%3E%0A%3C%2Fsvg%3E");
}
	
</style></head><body><article id="da499254-3110-4687-ad54-1e065bb9d7be" class="page sans"><header><div class="page-header-icon undefined"><span class="icon">🌊</span></div><h1 class="page-title">WORDWAVE (구현중)</h1><p class="page-description"></p></header><div class="page-body"><h1 id="d2b86aeb-360f-46ec-8349-13ee6f55a064" class=""><strong>📅</strong>기간</h1><p id="38b8ddd9-8d19-4eb7-b412-05bea943725f" class=""><strong>기획 및 개인 학습 :</strong> 23. 11. 15 ~ 23. 12. 31 </p><p id="8142b2ad-6ad4-4180-accd-e8e3ce54eef5" class=""><strong>구현 단계 :</strong> 24.1.1 ~ </p><p id="a6ffc62a-9310-4888-83c0-bbbddee8986f" class="">
</p><h1 id="7142ae01-d7a2-4b5a-a616-fae20b1c5454" class=""><strong>🎯 기획 배경</strong></h1><details open=""><summary style="font-weight:600;font-size:1.5em;line-height:1.3;margin:0"><strong>🖊</strong>영어 공부와 프로그래밍 공부를 동시에 하고싶어서</summary><div class="indented"><p id="4b82c322-acea-427d-b6a8-6244a30ca602" class="">영어는 ‘세계의 공통어’ 라고 할 정도로, 많이 쓰입니다.</p><p id="d9ef2fb2-ad50-482e-92c9-9c6d6351862e" class="">여행을 가서 대화를 통해 외국인 친구를 사귈 수 있고,</p><p id="c29f1826-9f96-40b9-ac8b-f89b445685a3" class="">해외 개발자와 영어를 사용해서 소통할 수 있고,</p><p id="4116e660-5085-4806-8913-24ed4f18aef4" class="">또는 채용 시장에서 공인 영어 실력을 증명해서 나만의 경쟁력을 증명할 수 있죠.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.5em;line-height:1.3;margin:0"><strong>🏃</strong>협업의 경험 쌓기</summary><div class="indented"><p id="bc133ea3-2033-49d1-bf08-d89db913a100" class="">저희 팀은 우테코 6기 프리코스에서 만났습니다.</p><p id="536ffb28-6891-4017-b024-0b826b0f124a" class="">그곳에서 인연이 되어 팀을 결성하고, 프리코스에서 배운 컨벤션들을 적용해서<br/>깔끔한 팀프로젝트를 만들어보기로 했습니다.<br/>우테코 프리코스에서는 CBD, TDD, Git 컨벤션, 도메인 로직 등 협업에 중요한 전략들을 배웠습니다. 배운 것들을 활용해 프로젝트를 만들며 ‘협업에 강한 개발자’가 되고자 시작했습니다.<br/></p><p id="bad0ea69-23ea-43ec-b8a5-b2492457605e" class="">
</p><p id="3b7ce752-611a-4201-b126-ea09b11d4f0b" class="">
</p></div></details><p id="dbf047ca-0599-4c05-9501-5a13a0503035" class="">
</p><h1 id="0cc7f3e0-05ce-43de-b742-821fb360128e" class=""><strong>⭐️ 주요 기능</strong></h1><h2 id="ececbe31-374f-4d2c-96bd-a7f8b5eb4660" class="">영어 단어 퀴즈</h2><ul id="560087b9-3f24-4be6-8260-bba46a35dec5" class="bulleted-list"><li style="list-style-type:disc">단어 문제 유형은 2가지가 있다.<ul id="47015b8e-a876-4427-9716-cb5ebfa5d37e" class="bulleted-list"><li style="list-style-type:circle">랜덤 : 문제는 풀떄마다 랜덤으로 유형이 바뀐다.</li></ul><ul id="3e571cfa-de94-4ea6-b998-b2e461e1f1cf" class="bulleted-list"><li style="list-style-type:circle">유형 1: 뜻을 제시하고, 객관식으로 맞춘다.</li></ul><ul id="8c24cd0b-a1b5-4666-aa8c-786a1f415fa0" class="bulleted-list"><li style="list-style-type:circle">유형 2: 일부분이 가려진 영단어를 제시하고, 주관식으로 해당 영단어를 맞춘다.</li></ul></li></ul><ul id="96af3c64-e0bb-4309-96e5-f86f41f0b0eb" class="bulleted-list"><li style="list-style-type:disc">제한시간 20초 내에 못 풀면 오답처리한다.</li></ul><ul id="292941cd-595c-4070-bd4c-e6ef3a5a5fb7" class="bulleted-list"><li style="list-style-type:disc">퀴즈를 다풀면 해당 카테고리에 대한 결과를 그래프로 표시한다.</li></ul><p id="bfe430f5-9b25-420a-b45b-da489b52c4e4" class="">
</p><h2 id="71a177f9-81fb-417a-b02f-711caff84760" class="">문법 퀴즈</h2><ul id="227b1e79-096b-428b-b23b-2c3466c4852b" class="bulleted-list"><li style="list-style-type:disc">문법 문제 유형은 2가지가 있다.<ul id="3361d36a-e12d-461e-8cda-c594664add2f" class="bulleted-list"><li style="list-style-type:circle">랜덤 : 문제는 풀떄마다 랜덤으로 유형이 바뀐다.</li></ul><ul id="ecfbc44b-ff11-454a-8d1c-ff84168de34b" class="bulleted-list"><li style="list-style-type:circle">유형 1: 빈칸이 포함된 문장이 제시되고, 문법에 맞는 단어를 객관식으로 선택해서 맞춘다.</li></ul><ul id="459dcae5-0ca7-4fb3-9022-913c44b48d67" class="bulleted-list"><li style="list-style-type:circle">유형 2:  뜻이 제시되고, 문법 블록을 클릭 및 조합을 해서 문법 문제를 맞춘다.</li></ul></li></ul><p id="6e40783f-a37f-4ad6-ace5-904f0974058c" class="">
</p><h2 id="d9b80cd1-7c76-4f9d-b5c9-a667b9b7f5b7" class="">실시간 영어 단어 배틀</h2><ol type="1" id="e3e95e3c-3ded-4760-9a10-e16297a2003c" class="numbered-list" start="1"><li>한 채팅방에 2명의 사용자가 접속한다.</li></ol><ol type="1" id="4bc85d17-e062-4621-bba0-6167af758e2d" class="numbered-list" start="2"><li>서버가 이미지를 제시하고, 2명의 사용자가 해당단어가 무엇인지 채팅으로 정답을 맞춘다.</li></ol><ol type="1" id="9940a415-5615-4597-b135-25c7fe52a798" class="numbered-list" start="3"><li>영단어를 먼저 맞춘 사용자의 점수가 올라가는 방식.</li></ol><p id="0d7b0c05-cebc-43fe-b061-d3c1a41af47b" class="">
</p><h1 id="d04a1939-39b8-4fd2-95e5-976173af9e54" class=""><strong>🛠️ 기술 스택</strong></h1><h1 id="2e12bc84-1a2f-4bf2-83ab-5ba82b4635bd" class="">프론트</h1><div id="b576ee83-2e7b-4c72-838a-c7cbdae8f312" class="column-list"><div id="37bca5c8-3015-459d-8eeb-31e4632166b1" style="width:39.26380368098161%" class="column"><figure id="963cdef7-9fc5-491d-88ec-26ec9db4adff" class="image" style="text-align:left"><a href="https://camo.githubusercontent.com/5e7e215d9ff3a7c2e96d09232c11b2205565c841d1129dd2185ebd967284121f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f68746d6c352d2532334533344632362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d68746d6c35266c6f676f436f6c6f723d7768697465"><img style="width:88px" src="https://camo.githubusercontent.com/5e7e215d9ff3a7c2e96d09232c11b2205565c841d1129dd2185ebd967284121f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f68746d6c352d2532334533344632362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d68746d6c35266c6f676f436f6c6f723d7768697465"/></a></figure><figure id="9b59d8d4-8064-4375-b81d-3b8c78724766" class="image" style="text-align:left"><a href="https://camo.githubusercontent.com/6531a4161596e3d9fdab3d0499a7b7ce5c5c8b568be219f3e9707af042e575d2/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f637373332d2532333135373242362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d63737333266c6f676f436f6c6f723d7768697465"><img style="width:77px" src="https://camo.githubusercontent.com/6531a4161596e3d9fdab3d0499a7b7ce5c5c8b568be219f3e9707af042e575d2/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f637373332d2532333135373242362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d63737333266c6f676f436f6c6f723d7768697465"/></a></figure><figure id="92a0687f-e156-4b67-8e81-196ad22370fc" class="image"><a href="https://camo.githubusercontent.com/53ec2e58e03ba275d9b3a386abd96a243cf744a1a7121bdf8262fc8ae6ebc335/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176617363726970742d2532333332333333302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661736372697074266c6f676f436f6c6f723d253233463744463145"><img style="width:144px" src="https://camo.githubusercontent.com/53ec2e58e03ba275d9b3a386abd96a243cf744a1a7121bdf8262fc8ae6ebc335/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176617363726970742d2532333332333333302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661736372697074266c6f676f436f6c6f723d253233463744463145"/></a></figure></div><div id="4815662b-f210-4b84-9b5e-53b760f756fd" style="width:40.490797546012274%" class="column"><figure id="2d925913-ac9f-4197-9c8b-148eb4233143" class="image"><a href="https://camo.githubusercontent.com/3babc94d778f96441b3a66615fb5ee88c6ed04f174ed49b04df92b071a7d0e80/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f72656163742d2532333230323332612e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d7265616374266c6f676f436f6c6f723d253233363144414642"><img src="https://camo.githubusercontent.com/3babc94d778f96441b3a66615fb5ee88c6ed04f174ed49b04df92b071a7d0e80/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f72656163742d2532333230323332612e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d7265616374266c6f676f436f6c6f723d253233363144414642"/></a></figure><figure id="8f846521-c019-4f2b-af96-6d4193a3d04b" class="image" style="text-align:left"><a href="https://camo.githubusercontent.com/4da1605c9c424c73f102b2be0a900d8fc55083441b2eda9964e9307770032fa3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5374796c6564636f6d706f6e656e742d4442373039333f7374796c653d666f722d7468652d6261646765266c6f676f3d7374796c6564636f6d706f6e656e7473266c6f676f436f6c6f723d7768697465"><img style="width:60px" src="https://camo.githubusercontent.com/4da1605c9c424c73f102b2be0a900d8fc55083441b2eda9964e9307770032fa3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5374796c6564636f6d706f6e656e742d4442373039333f7374796c653d666f722d7468652d6261646765266c6f676f3d7374796c6564636f6d706f6e656e7473266c6f676f436f6c6f723d7768697465"/></a></figure><figure id="891f6859-30e5-4a73-bc05-eb62e3c516af" class="image"><a href="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/icons8-redux-an-open-source-javascript-library-for-managing-application-state-96.png"><img style="width:96px" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/icons8-redux-an-open-source-javascript-library-for-managing-application-state-96.png"/></a></figure></div><div id="16c66a7a-ecc9-4611-960a-326677b42683" style="width:20.245398773006137%" class="column"><figure id="3b340206-65cc-43c0-87a5-0161a2cde257" class="image"><a href="https://camo.githubusercontent.com/eb158764299635e01f05400dde56b7d3e6d1a147612e349dded5c08b8fa042ed/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6178696f732d3541323945343f7374796c653d666f722d7468652d6261646765266c6f676f3d6178696f73266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/eb158764299635e01f05400dde56b7d3e6d1a147612e349dded5c08b8fa042ed/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6178696f732d3541323945343f7374796c653d666f722d7468652d6261646765266c6f676f3d6178696f73266c6f676f436f6c6f723d7768697465"/></a></figure><p id="0daa3655-2660-4cc9-8efc-5bd1cba5ec6f" class="">
</p></div></div><p id="70f5024f-3d5b-42a1-9ed1-ddfc6e4efd1c" class="">
</p><h1 id="1db19029-8169-484a-a406-d1719d785688" class="">백엔드</h1><div id="ab988fa2-b1d7-4ce8-b458-0446f716603e" class="column-list"><div id="3ac43af0-7489-4f66-bcdf-8239ca6c67d3" style="width:25%" class="column"><figure id="a283ccef-486b-4063-b66c-05db92c77266" class="image"><a href="https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465"/></a></figure><figure id="2d97b466-2fa1-4ba1-b053-3e2b85005e74" class="image"><a href="https://camo.githubusercontent.com/aac74ca85b21ed1ff4fa88dda8712fce9cddbf786bdf807231e6179f70003ac5/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73"><img src="https://camo.githubusercontent.com/aac74ca85b21ed1ff4fa88dda8712fce9cddbf786bdf807231e6179f70003ac5/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73"/></a></figure></div><div id="a52e9383-b755-4cee-843b-13687826a2af" style="width:25%" class="column"><figure id="1e05e319-e272-4194-bcf9-4baf6570f82b" class="image"><a href="https://camo.githubusercontent.com/42dd3f9f9345fb4a3e1a24d0483c62ac853b227b6bec314dbd09aa0d9edc9671/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e67626f6f742d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67626f6f74266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/42dd3f9f9345fb4a3e1a24d0483c62ac853b227b6bec314dbd09aa0d9edc9671/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e67626f6f742d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67626f6f74266c6f676f436f6c6f723d7768697465"/></a></figure><figure id="f6646dbf-3f2c-45fd-a917-cbcee1e99a00" class="image"><a href="https://camo.githubusercontent.com/73e403d49e115d16cfca0f675bd93fad1aaf60b3b2e2cb6938b7aad13abc9b09/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e6773656375726974792d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e677365637572697479266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/73e403d49e115d16cfca0f675bd93fad1aaf60b3b2e2cb6938b7aad13abc9b09/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e6773656375726974792d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e677365637572697479266c6f676f436f6c6f723d7768697465"/></a></figure></div><div id="0efa4b15-f48a-403c-9c2c-4018483aa49b" style="width:25%" class="column"><figure id="dcd44a8c-3674-468f-8008-a9aa729ad100" class="image"><a href="https://camo.githubusercontent.com/92e843af63a4c5e2f893e9e1d2ed37f768c5a74315c8af46b16fe8661929266b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616d617a6f6e6563322d4646393930303f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e656332266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/92e843af63a4c5e2f893e9e1d2ed37f768c5a74315c8af46b16fe8661929266b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616d617a6f6e6563322d4646393930303f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e656332266c6f676f436f6c6f723d7768697465"/></a></figure></div><div id="5cdcbfd8-8f5f-4a10-9a9f-b72518b405a1" style="width:25%" class="column"><figure id="880f10c0-0f38-4f52-8dd2-25e1d73cfb36" class="image"><a href="https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465"/></a></figure></div></div><p id="0b414c74-8bc9-4a12-8581-95c09070a4e8" class="">
</p><h1 id="b300e9b1-2877-4507-9778-cd3c5205f635" class="">협업</h1><figure id="50ee365d-70ce-4675-86d2-5ec03ba9574d" class="image" style="text-align:left"><a href="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled.png"><img style="width:98px" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled.png"/></a></figure><figure id="80955660-c81a-4cdb-8024-ae8e6289f897" class="image" style="text-align:left"><a href="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled%201.png"><img style="width:48px" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled%201.png"/></a></figure><p id="5e3cca99-b06a-48d0-99ef-e12f03ff380a" class="">
</p><p id="b4a212da-ac95-40bb-ab31-137ab5ad3793" class="">
</p><p id="b8a512d5-d899-446e-95f9-f86d88f1c1cf" class="">
</p><h1 id="fb832a98-ebfe-4d1e-8ece-82c06665a519" class=""><strong>📋</strong>트러블슈팅 희고록</h1><h2 id="b0889c7f-b0d9-4298-a882-d4f45f129057" class="">백엔드</h2><hr id="1d527082-4ea2-4f80-9a30-4a834c90bd5c"/><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">스프링시큐리티 라이브러리 import를 어떤것을 해야하는가?<br/>(servlet, reactive)<br/></summary><div class="indented"><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="20f97beb-6ede-450d-8f0d-bf882026539f" class="code"><code class="language-Java">import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;</code></pre><h3 id="6c537c28-5e7d-49a8-815a-9530ae0204f0" class="">문제</h3><p id="8d5b2529-f434-47b0-87ed-bd099c851044" class="">SpringSecrutiy가 버전업이 되면서 기존의 코드들이 레거시코드들이 되거나 deprecated가 되버렸다.</p><p id="cbc446b3-06a0-45f6-b9ef-912ba2f31c00" class="">코드 리팩토링중에 어떠한 import문을 써야하는지 헷갈림에 직면했다.</p><p id="0bf6f2fe-54bb-4901-b34b-e9b4676b7fa2" class="">우리는 Spring+React 프로젝트이다, 어떤것을 써야할까?</p><p id="f5e3892b-f3a0-4bca-a856-473ea878b791" class="">
</p><h3 id="b02d9db8-085f-42b4-8eba-2c32b332c4df" class="">해결</h3><ol type="1" id="f47052d2-3b42-4150-bb0e-593b8a55a32b" class="numbered-list" start="1"><li><strong>서블릿 기반의 스프링 MVC와 </strong><code><strong>org.springframework.boot.autoconfigure.security.servlet.PathRequest</strong></code><strong> 사용:</strong><ul id="1416f810-55ed-439d-90b2-bb8409f94dfc" class="bulleted-list"><li style="list-style-type:disc">기존에 서블릿 기반의 스프링 MVC를 사용하고 있거나, 향후에도 서블릿 기반의 애플리케이션을 계속 사용할 계획이 있다면 이를 선택할 수 있습니다.</li></ul><ul id="03ba1a1c-b1f8-41fa-973b-97fc45ac2ea9" class="bulleted-list"><li style="list-style-type:disc">이 경우에는 <code><strong>org.springframework.boot.autoconfigure.security.servlet.PathRequest</strong></code>를 사용하여 경로 요청에 대한 보안 구성을 지원할 수 있습니다.</li></ul></li></ol><ol type="1" id="fb7ad2a9-4149-427f-9666-66d8ab9d5c84" class="numbered-list" start="2"><li><strong>WebFlux와 </strong><code><strong>org.springframework.boot.autoconfigure.security.reactive.PathRequest</strong></code><strong> 사용:</strong><ul id="1452f8c9-4886-4aa6-881d-bd4ac018f5cf" class="bulleted-list"><li style="list-style-type:disc">React와 함께 비동기 및 Reactive한 프로그래밍 스타일을 사용하려는 경우, 혹은 향후에도 리액티브한 방식으로 개발하고자 하는 경우에는 WebFlux와 해당 패키지를 사용하는 것이 좋습니다.</li></ul><ul id="d516e5b7-e4d4-4ce8-ae24-87a5001f1be1" class="bulleted-list"><li style="list-style-type:disc"><code><strong>org.springframework.boot.autoconfigure.security.reactive.PathRequest</strong></code>는 Reactive 스타일의 애플리케이션과 함께 사용됩니다.</li></ul></li></ol><p id="7000472a-7db1-4154-bd55-d820d2ac10e8" class="">
</p><blockquote id="1501182e-af76-44c9-ab17-4c499acfa18e" class="">따라서 프로젝트의 성격과 향후 개발 방향을 고려하여 두 가지 중 하나를 선택하면 됩니다.<br/>만약 새로운 프로젝트를 시작하는 경우에는 React와의 통합을 고려하여 WebFlux와 <br/><code><strong>org.springframework.boot.autoconfigure.security.reactive.PathRequest</strong></code>를 선택하는 것이 더욱 적합할 것입니다.</blockquote><p id="10cb5b2b-338a-4cab-9d12-67eb769937d0" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">스프링 시큐리티 관련 기능 구현중에 <mark class="highlight-red">꼭 알아야할것!</mark></summary><div class="indented"><p id="403a4d60-041a-4612-86d1-b75f7bc48139" class="">스프링 시큐리티 config를 작성하기 전 알고 넘어가야하는 것이 있다.</p><p id="c4cbe279-4a30-44a8-a5ab-53cb8fdd3e77" class="">Spring Security 5.7 이후부터 @Bean으로 SecurityFilterChain을 구현해서 시큐리티를 적용시키는 방법을 권장하기 때문에 필터체인 구성을 extends로 하는 이전방식을 사용하지 않고 빈등록 방식으로 코드를 작성했다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0"><strong>JSON 변환 과정에서의 순환 참조 문제 해결<br/>(양뱡향참조-무한루프 문제)<br/></strong></summary><div class="indented"><details open=""><summary style="font-weight:600;font-size:1.5em;line-height:1.3;margin:0"><strong>Jackson</strong></summary><div class="indented"><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="ab320960-6769-4be1-a9fc-cbf3d116c401"><div style="font-size:1.5em"><span class="icon">💡</span></div><div style="width:100%"><mark class="highlight-red">JSON (JavaScript Object Notation) 데이터를 Java 객체로 변환</mark>하거나,<br/>그 반대로 <br/><mark class="highlight-red">Java 객체를 JSON 데이터로 변환하는 작업을 수행하는 라이브러리</mark>입니다.<br/>이런 변환 작업을 <br/><strong>&#x27;직렬화(Serialization)&#x27;</strong>와 &#x27;<strong>역직렬화</strong>(Deserialization)&#x27;라고 합니다.</div></figure><p id="b600acab-68c4-40d7-a888-ebd424e6aac4" class=""><strong>직렬화:</strong></p><p id="06b7b55c-af4e-4d8b-b705-bb54d16c5a7e" class="">Java 객체를 JSON 형태의 문자열로 변환하는 작업. 이는 RESTful API에서 응답 데이터를 생성할 때 주로 사용됩니다.</p><p id="b9a94be9-48f1-4e37-87e4-4567038fa034" class=""><strong>역직렬화:</strong></p><p id="0bf7bec4-eb6b-465a-947e-d96a8cdb16bc" class="">JSON 형태의 문자열을 Java 객체로 변환하는 작업. 이는 API에서 요청 데이터를 받아 처리할 때 주로 사용됩니다.</p><p id="8c8e7a83-692d-41c6-9809-036b5051ecdd" class=""><strong>데이터 바인딩:</strong></p><p id="add6ded5-964c-4973-b3ad-193631c8aba9" class="">JSON을 Java 객체로 변환하거나 그 반대의 작업을 수행할 때, 어떤 JSON 필드가 어떤 Java 객체의 어떤 필드와 연결되는지를 정의합니다.</p><p id="208b6b57-03c0-43ae-8476-3872fea0a7c9" class=""><strong>어노테이션:</strong></p><p id="843f90c7-60cc-4634-8331-6686baeea43f" class="">Jackson은 다양한 어노테이션을 제공하여, 직렬화/역직렬화 과정에서의 세부적인 동작을 제어할 수 있게 합니다.</p><p id="fdc1342f-6057-4aee-83ae-2d1371c21d78" class="">예를 들어, <code>@JsonIgnore</code> 어노테이션은 특정 필드를 직렬화 과정에서 무시하도록 지시할 수 있습니다.</p><p id="df47b454-a673-4c9b-8180-abaf6c4d03cc" class=""><strong>프리티 프린트:</strong></p><p id="8b328f3f-ecdf-4c16-918e-855ea12e3287" class="">JSON 데이터를 읽기 좋은 형태로 출력하는 기능입니다.</p></div></details><blockquote id="8f28a614-2122-4587-aa58-98f8e2f29c9a" class="">Jackson에 대해서 궁금하다면 위에 정보를 보자.</blockquote><h3 id="1d93d4f3-2c66-4da3-9b0f-f8660c8b7d82" class="">문제</h3><p id="cf06964a-7522-4871-a6e7-b67052179636" class="">양방향 연관 관계를 가지는 엔티티 클래스들이 JSON으로 변환되는 과정에서 각각이 서로를 참조하면서 무한루프가 발생했음</p><h3 id="f52caf9d-f9c7-487a-989f-c13aeaf54109" class="">해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="a9dba582-7a98-4210-af94-9d0d17ca3dc6" class="code"><code class="language-Java">@Entity
@Getter
public class VocaBook {
    // ...
    @OneToMany(mappedBy = &quot;vocaBook&quot;)
    @JsonManagedReference // 추가
    private List&lt;Voca&gt; vocas = new ArrayList&lt;&gt;();
    // ...
}

@Entity
@Getter
@NoArgsConstructor
public class Voca {
    // ...
    @ManyToOne
    @JsonBackReference // 추가
    private VocaBook vocaBook;
    // ...
}</code></pre><p id="4e85cdba-fd5c-46d7-b3af-1a379ef0e714" class=""><code><strong>@JsonManagedReference</strong></code><strong>, </strong><code><strong>@JsonBackReference</strong></code><strong>, </strong><code><strong>@JsonIdentityInfo</strong></code><strong> 등의 어노테이션을 사용하여 순환 참조 문제를 해결했음</strong></p><p id="0533822e-d473-4cbd-9cf9-515e5fa7d388" class="">
</p><p id="f7d1fc36-857d-4755-95db-0540a74b96fd" class=""><code>@JsonManagedReference</code>는 순환 참조의 &#x27;부모&#x27; 쪽에 두고, <code>@JsonBackReference</code>는 &#x27;자식&#x27; 쪽에 둡니다.</p><p id="b188255b-5923-47c8-b78c-cbe8085a03c8" class="">이렇게 하면, <code>VocaBook</code>을 JSON으로 변환할 때 <code>Voca</code> 리스트가 포함되지만, 각 <code>Voca</code>는 다시 <code>VocaBook</code>을 참조하지 않게 됩니다. 이로써 무한루프 문제를 해결할 수 있습니다.</p><p id="58ca81bb-196b-4f8f-bce1-b582ecdf157a" class="">이 외에도 <code>@JsonIdentityInfo</code> 어노테이션을 사용하여 순환 참조 문제를 해결할 수 있습니다. 이 어노테이션은 엔티티의 ID를 이용하여 순환 참조를 방지합니다.</p><p id="9393c715-da95-4eeb-8653-14bdf9453916" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">LazyInitializationException - JJY</summary><div class="indented"><h3 id="12fad69b-a48f-4c4a-9e67-024548e22e1d" class="">오류 발견</h3><p id="82250000-e1db-4937-9869-9f8d6b730543" class="">아래 코드를 테스트하던 중 LazyInitializationException이 발생했습니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="06ec1919-587b-4ff8-bbb2-ac8dca940324" class="code"><code class="language-Java">public GrammarBookResponseDto getUserWrongGrammarBook(String userName, String grammarBookName) {
    Long userId = getUserIdByUserName(userName);
    List&lt;UserGrammarStatus&gt; userGrammarStatuses = this.userGrammarStatusRepository.findByUserId(userId);
    Long grammarBookId = this.grammarBookService.getGrammarBookIdByGrammarBookName(grammarBookName);

    List&lt;GrammarDto&gt; grammarDtos = new ArrayList&lt;&gt;();
    for (UserGrammarStatus userGrammarStatus : userGrammarStatuses) {
        if (userGrammarStatus.getGrammarBookId() != null &amp;&amp; userGrammarStatus.getGrammarBookId().equals(grammarBookId)) {
            grammarDtos.add(this.grammarService.getGrammar(userGrammarStatus.getWrongGrammarId()));
        }
    }
    return GrammarBookResponseDto.builder()
            .id(grammarBookId)
            .name(grammarBookName)
            .grammars(grammarDtos)
            .build();
}</code></pre><p id="e7005d4a-0546-4ef0-a476-4b7478839fce" class="">오류 로그는 다음과 같습니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="b115290e-e330-41f3-818c-22814fc3dab3" class="code"><code class="language-Plain Text">org.hibernate.LazyInitializationException: could not initialize proxy [com.wordwave.grammarbook.GrammarBook#14] - no Session
	at org.hibernate.proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer.java:164)
	at org.hibernate.proxy.AbstractLazyInitializer.getImplementation(AbstractLazyInitializer.java:310)
	at org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor.intercept(ByteBuddyInterceptor.java:44)
	at org.hibernate.proxy.ProxyConfiguration$InterceptorDispatcher.intercept(ProxyConfiguration.java:102)
	at com.wordwave.grammarbook.GrammarBook$HibernateProxy$a5pHvLS3.getName(Unknown Source)
	at com.wordwave.grammar.GrammarService.getGrammar(GrammarService.java:29)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:713)
	at com.wordwave.grammar.GrammarService$$SpringCGLIB$$0.getGrammar(&lt;generated&gt;)
	at com.wordwave.grammar.UserGrammarStatusService.getUserWrongGrammarBook(UserGrammarStatusService.java:63)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:713)
	at com.wordwave.grammar.UserGrammarStatusService$$SpringCGLIB$$0.getUserWrongGrammarBook(&lt;generated&gt;)
	at com.wordwave.grammar.UserGrammarStatusServiceTest.getUserWrongGrammarBookTest(UserGrammarStatusServiceTest.java:46)
	...</code></pre><h3 id="8a7552f1-fef1-4c2f-9554-799651e2a56a" class="">오류 원인</h3><p id="e0deaa00-7568-4422-a060-eb28b18f8038" class=""><code>org.hibernate.LazyInitializationException</code>은 준영속 상태의 프록시를 초기화하면 발생합니다.</p><blockquote id="64c428b5-e4fb-4003-b81a-788871b0ae31" class="">준영속(detached) 상태란, 엔티티 객체가 영속성 컨텍스트에 있다가 분리된 상태입니다. 준영속 상태의 엔티티 객체는 영속성 컨텍스트의 기능을 사용할 수 없습니다.</blockquote><blockquote id="50e72b07-07d5-4548-bfaa-8590f1340680" class="">프록시 초기화란, 영속 상태의 프록시 객체의 메서드를 이용하려 할때 프록시 객체가 영속성 컨텍스트에 요청해 실제 엔티티 객체를 데이터베이스에서 불러와 참조하는 것입니다.</blockquote><p id="76a17182-6d2e-4316-9431-c457d56aaa75" class=""><br/>for문 안에서 <br/><code>getGrammar()</code>를 여러 번 반복하는 동안, 동일한 GrammarBook과 연관관계를 맺고 있는 여러 Grammar가 존재할 수 있습니다.</p><p id="d9748d3c-d3ff-4fb0-a84a-839e260d2bc5" class="">만약 <code>getGrammar()</code>가 호출되어 GrammarBook에 접근하여 grammarBookName을 가져오기 위해 GrammarBook 프록시 객체를 초기화하고, 필요한 데이터를 가져온뒤 메서드가 종료되었다고 해봅시다. 이때 영속성 컨텍스트에서는 해당 GrammarBook 엔티티 객체와 프록시 객체는 준영속 상태가 되지만, 프록시 객체는 PK값을 갖고 있습니다. </p><p id="5b1a02e7-3880-4fd0-8584-27b061fd7d48" class="">그 뒤에 또 <code>getGrammar()</code>가 호출되고, 해당 Grammar가 이전과 같은 GrammarBook에 접근한다면 JPA는 같은 PK값을 가진 프록시 객체를 먼저 이용하려고 듭니다.</p><p id="2e0a5420-8beb-48e5-9dd1-789bc546c1d8" class="">그리고 <code>getName()</code>으로 grammarBookName값을 가져오려고 하는데, PK값이 아닌 데이터에 접근하려면 프록시를 초기화해야 합니다. 하지만 이미 이 프록시 객체는 준영속 상태여서 영속성 컨텍스트에 프록시 초기화 요청을 하지 못합니다. 그래서 <code>org.hibernate.LazyInitializationException</code>가 발생했다고 생각합니다.</p><h3 id="2454f1a0-6078-4574-a80a-9477bcfc3036" class="">오류 해결</h3><p id="d4b6f01b-c1c1-426d-aca9-1a40604cbd3a" class="">문제의 메서드에 <code>@Transactional</code>을 붙이면 메서드가 끝날때까지 메서드 실행중 생성되는 영속성 컨텍스트내 엔티티 객체를 제거하지 않습니다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0"><code><strong>Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.IllegalArgumentException:</strong></code><strong> </strong></summary><div class="indented"><p id="60ece52a-87e7-46f5-b0fc-c2d9cb5d3b01" class="">
</p><h3 id="be3692bb-6a1e-4a4c-ad2f-0188aaee0a61" class="">문제</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="dee47fae-f16e-4a27-9aec-d50ed04f10a9" class="code"><code class="language-JavaScript">@GetMapping(&quot;{vocaBookId}&quot;)
	public ResponseEntity&lt;?&gt; getVocaBookDetail(@PathVariable long vocaBookId){
		try {
			Map&lt;Long,List&lt;String&gt;&gt; categories = vocaBookService.getCategoriesOfVocaBook(vocaBookId);
			return ResponseEntity.ok().body(categories);
		} catch (Exception e) {	
			e.printStackTrace();
			return ResponseEntity.badRequest().body(&quot;VocaBook 불러오기 실패!&quot;);
		}
	}</code></pre><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="8dcb75fe-067c-4a18-96bc-9e00a53ed6c0" class="code"><code class="language-JavaScript">@Query(&quot;select v.category from Voca v where v.vocaBook.id = :vocaBookId&quot;)
    List&lt;String&gt; findCategoriesByVocaBookId(@Param(&quot;vocaBookId&quot;) long vocaBookId);</code></pre><p id="327ccc63-f618-4d1d-baa7-3538eb328cfa" class=""><strong></strong><code>@Param</code> 애너테이션이 올바르게 사용되지 않았을 때 발생하는 오류 였는데,<br/><br/><code>@Param</code> 애너테이션은 메서드의 매개변수를 SQL 쿼리의 파라미터로 바인딩할 때 사용하는데, 이때 매개변수 이름과 <code>@Param</code>의 값이 일치해야 합니다.</p><p id="052f3711-3f45-42b3-8fc2-481ece1d5781" class="">
</p><h3 id="40690766-e96d-4285-8050-b73c9c1beb09" class="">해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="9d9c8fc9-b03e-4ebf-a935-d6177539430d" class="code"><code class="language-Java">@GetMapping(&quot;{vocaBookId}&quot;)
	public ResponseEntity&lt;?&gt; getVocaBookDetail(@PathVariable(&quot;vocaBookId&quot;) long vocaBookId){
		try {
			Map&lt;Long,List&lt;String&gt;&gt; categories = vocaBookService.getCategoriesOfVocaBook(vocaBookId);
			return ResponseEntity.ok().body(categories);
		} catch (Exception e) {	
			e.printStackTrace();
			return ResponseEntity.badRequest().body(&quot;VocaBook 불러오기 실패!&quot;);
		}
	}</code></pre><p id="eb2628ca-2e9a-4bc0-8b11-73163fd28706" class="">위의 코드에서 <code>@PathVariable(&quot;vocaBookId&quot;)</code>는 URL의 <code>{vocaBookId}</code> 부분을 <code>long vocaBookId</code> 매개변수에 바인딩합니다. 따라서 클라이언트가 <code>/api/vocabook/1</code>과 같은 URL로 요청을 보내면, <code>vocaBookId</code> 매개변수는 <code>1</code>이라는 값을 가지게 됩니다.</p><p id="cb4e7848-8784-4205-86ef-1804da423a68" class="">따라서, <code>@PathVariable</code> 애너테이션에 매개변수의 이름을 명시함으로써 문제가 해결되었습니다. 이제 클라이언트는 <code>vocaBookId</code>를 통해 특정 단어장의 세부 정보를 요청할 수 있습니다.</p><p id="00239eff-2d41-476e-bacc-426f0c004318" class="">
</p></div></details><p id="c1061707-23a8-46e1-a1d1-eb9fe51841ff" class="">
</p><h2 id="ae9f5727-be63-4e44-8972-ccf3af920bb2" class="">프론트</h2><hr id="dc45015d-bf36-40b9-a9ed-39e50cb8d09c"/><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0"><strong>redux-devtools-extension 의 의존성 충돌 문제</strong></summary><div class="indented"><p id="9c6db622-f312-4a59-84b3-42886d593243" class=""><strong>참고</strong></p><figure id="d8bd2b7d-b6d9-4358-9954-7d774388642e"><a href="https://disco-biscuit.tistory.com/68" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">패키지 의존성 충돌 버전 에러 해결 ERESOLVE unable to resolve dependency tree</div><div class="bookmark-description">에러 원인 redux-actions을 설치하고 npm run dev를 했는데 &#x27;vite&#x27;은(는) 내부 또는 외부 명령, 실행할 수 있는 프로그램, 또는 배치 파일이 아닙니다. 이런 오류가 떠서 yarn.lock과 pakage-lock.json 파일을 삭제해주고 npm install을 했는데 뜬 오류다. (redux-actions를 설치했는데 왜 redux-devtools-extension과 redux의 버전충돌이 이제서야 뜨는건지 모르겠다.. ) npm ERR! code ERESOLVE npm ERR! ERESOLVE unable to resolve dependency tree npm ERR! npm ERR! While resolving: react-redux-tutorial@0.0.0 npm ERR! ..</div></div><div class="bookmark-href"><img src="https://t1.daumcdn.net/tistory_admin/favicon/tistory_favicon_32x32.ico" class="icon bookmark-icon"/>https://disco-biscuit.tistory.com/68</div></div><img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&amp;fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FQxt5T%2FbtsB6mLSFy5%2F5BO4oPhPya8TUVtxk55La0%2Fimg.png" class="bookmark-image"/></a></figure><p id="71cb684c-fa23-4593-90d8-65f778686cfd" class="">redux-devtools-extension 해당 라이브러리는<br/>redux 패키지랑 호환되는 버전이 <br/><code><strong>^3.1.0 || ^4.0.0</strong></code><strong> </strong>만 가능하다</p><h3 id="93a5b5ac-dd9b-416f-a557-2243c5249049" class="">해결법</h3><p id="a95b3fc5-10e2-4b66-b4d1-11a4efce8faa" class="">pakeage.json에서 redux 버전을 다운그레이드 한다.</p><p id="34c747ad-06c1-4e22-99d4-42ea79a0fb21" class="">여기서 나는 4.0.0로 다운그레이드 했다.</p><p id="06b6b026-206f-4ea1-8c17-012abcc0ff6b" class="">그 이후 터미널에서</p><p id="3a6d6575-0b6b-4093-918f-025401304d02" class=""><code><strong>npm install -force</strong></code></p><p id="476132d9-a310-4741-b7c3-91517965b708" class="">해당 명령어를 입력 후 재설치 했다.</p><p id="60e3c454-c2d6-4360-9ba5-554ca70ff9fe" class=""><code>npm install --save redux-devtools-extension</code></p><p id="64ea7183-9d3f-4a1a-91e7-846b80e87e2e" class="">
</p><h3 id="b0e0578f-21f4-432e-a0cf-ee4b2e9c5b30" class="">더 좋은 해결법</h3><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="3a278f8b-e56c-4b3c-918c-3047e55c037c"><div style="font-size:1.5em"><span class="icon">💡</span></div><div style="width:100%"><strong>Redux Toolkit  을 쓰자<br/>해당 라이브러리에 어차피 <br/></strong>redux-devtools-extension 내장됐다.<br/><br/><code><strong>npm install @reduxjs/toolkit</strong></code></div></figure><p id="6e9286fd-af00-4ca5-ba49-0580e53f5ad9" class="">
</p><p id="df6c49e0-3d7f-478d-918c-0673ebfad31e" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">전역 상태관리가 새로고침(Redirect) 해야만 반영 되는 문제</summary><div class="indented"><h3 id="d746fb52-7882-4e07-855f-328df37662ba" class="">문제</h3><p id="bf2d7380-9df6-4b7b-84ad-289303e85143" class="">로그인중(로그인유지)라는 상태가 전역적으로 유지는 됐지만,</p><p id="35430f3c-125a-40bc-b1d1-c951f0f5c681" class="">이것이 새로고침을 한번 해줘야 반영이되는 불편함이 생겼다.</p><p id="9b745d31-0f66-48c7-93b3-3b1d64729495" class="">
</p><h3 id="1e1fb17e-8449-49ca-81b7-43045b9226df" class="">해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="77078bcc-2b68-4372-a121-6a2f38b85bea" class="code"><code class="language-JavaScript">import LayoutContainer from &quot;./containers/LayoutContainer&quot;;
import GrammarPage from &quot;./pages/GrammarPage&quot;;
import { Navigate, Route, Routes } from &quot;react-router-dom&quot;;
import NotFoundPage from &quot;./pages/NotFoundPage&quot;;
import HomePage from &quot;./pages/HomePage&quot;
import LoginPage from &quot;./pages/LoginPage&quot;;
import { useEffect, useState } from &quot;react&quot;;
import { useSelector } from &quot;react-redux&quot;;

function App() {
  const [loging,setLoging] = useState(sessionStorage.getItem(&#x27;isLoging&#x27;) || &#x27;&#x27;);
  const { isLoging } = useSelector(state=&gt;state.auth);

  useEffect(() =&gt; {
    if(isLoging) return setLoging(true);
  }, [loging,isLoging]);

  console.log(&#x27;is Login : &#x27;+sessionStorage.getItem(&#x27;isLoging&#x27;));

  return (
    &lt;Routes&gt;
      &lt;Route path=&quot;/&quot; element={&lt;LayoutContainer /&gt;}&gt;
        &lt;Route index element={&lt;HomePage /&gt;} /&gt;
        &lt;Route path=&quot;*&quot; element={&lt;NotFoundPage /&gt;} /&gt;
        &lt;Route path=&quot;grammar&quot; element={sessionStorage.getItem(&#x27;isLoging&#x27;) ? &lt;GrammarPage /&gt; : &lt;Navigate to=&quot;/login&quot; /&gt;} /&gt;
        &lt;Route path=&quot;login&quot; element={sessionStorage.getItem(&#x27;isLoging&#x27;) === null || sessionStorage.getItem(&#x27;isLoging&#x27;) === &quot;false&quot; ? &lt;LoginPage /&gt; : &lt;Navigate to=&quot;/&quot; /&gt;} /&gt;
        {/* &lt;Route path=&quot;grammar&quot; element={isLoging ? &lt;GrammarPage /&gt; : &lt;Navigate to=&quot;/login&quot; /&gt;} /&gt;
        &lt;Route path=&quot;login&quot; element={!isLoging ? &lt;LoginPage /&gt; : &lt;Navigate to=&quot;/&quot; /&gt;} /&gt; */}
      &lt;/Route&gt;
    &lt;/Routes&gt;
  );
}

export default App;</code></pre><p id="99555549-9f4c-4ba3-925f-fa7e6d9a895a" class="">
</p><p id="c8524d92-88de-487a-a30a-4d16e8c47e34" class="">session에 있는 로그인유무 상태 값을 App.js에서 스토어에서 가져온 값에따라<br/>지속적으로 업데이트를 useEffect를 통해 해주었다.<br/></p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">적용된 커스텀 폰트가 시스템 폰트가 잠시 로드 되다가, 다시 나오는 문제</summary><div class="indented"><h3 id="9370d3b6-464a-408d-a460-e87eb1d14534" class="">문제</h3><p id="bf8d1d45-6b34-4b01-8ef3-624a36a7eec1" class="">적용된 커스텀 폰트가 바로 적용되어야 하는데,</p><p id="3b22098c-4b0d-415a-a524-38bcc67f345b" class="">리다이렉트 되거나, 다른 컴포넌트가 랜더링 될떄, 잠시 시스템폰트가 로드 되다가,</p><p id="1834b80f-6a98-4d14-a4de-d957de47e136" class="">커스텀 폰트가 나오는 불쾌한 현상이 있었다.</p><p id="59fea2d8-7916-49b0-bb71-1b8b61afccb5" class="">
</p><h3 id="e05295ca-c7d4-4185-b415-accd1609c223" class="">해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="6515f1c7-fe62-4493-b887-53438409327c" class="code"><code class="language-JavaScript">&lt;!DOCTYPE html&gt;
&lt;html lang=&quot;en&quot;&gt;
  &lt;head&gt;
    &lt;meta charset=&quot;utf-8&quot; /&gt;
    &lt;link rel=&quot;icon&quot; href=&quot;%PUBLIC_URL%/favicon.ico&quot; /&gt;
    &lt;meta name=&quot;viewport&quot; content=&quot;width=device-width, initial-scale=1&quot; /&gt;
    &lt;meta name=&quot;theme-color&quot; content=&quot;#000000&quot; /&gt;
    &lt;meta
      name=&quot;description&quot;
      content=&quot;Web site created using create-react-app&quot;
    /&gt;
    &lt;link rel=&quot;apple-touch-icon&quot; href=&quot;%PUBLIC_URL%/apple-icon-57x57.png&quot; /&gt;
    &lt;link rel=&quot;manifest&quot; href=&quot;%PUBLIC_URL%/manifest.json&quot; /&gt;
    &lt;link rel=&quot;preload&quot; href=&quot;./resources/GmarketSansTTFLight.ttf&quot; as=&quot;font&quot; type=&quot;font/ttf&quot; crossorigin=&quot;anonymous&quot;&gt;
    &lt;title&gt;WORDWAVE&lt;/title&gt;
  &lt;/head&gt;
  &lt;body&gt;
    &lt;div id=&quot;root&quot;&gt;&lt;/div&gt;
  &lt;/body&gt;
&lt;/html&gt;</code></pre><p id="7fafd6c6-13fa-489d-9d05-ae6672bad76e" class=""><code>&lt;link rel=&quot;preload&quot; href=&quot;./resources/GmarketSansTTFLight.ttf&quot; as=&quot;font&quot; type=&quot;font/ttf&quot; crossorigin=&quot;anonymous&quot;&gt;</code><br/>해당 코드로 페이지가 로드 되자마자 폰트를 가져오게 했고,<br/></p><p id="2a545a8b-6620-48e9-95ca-e0e9050b972f" class="">
</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="be0b0642-7ce8-4ba6-afa7-57bc7aeb78bb" class="code"><code class="language-JavaScript">const GlobalStyle = createGlobalStyle`
@font-face {
    font-family: &#x27;GmarketSansTTFLight&#x27;;
    src: url(${GmarketSansTTFLight}) format(&#x27;truetype&#x27;);
    font-weight: normal;
    font-style: normal;
    font-display: &#x27;optional&#x27;;
}</code></pre><p id="98f79d32-187f-41aa-a1ec-7c17383a10a0" class=""><code>font-display: &#x27;optional&#x27;; </code></p><p id="6c855ebf-e5b8-4eed-9490-be7267d6222b" class="">이러한 옵션을 걸어주었다.<br/><br/></p><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="c6611c52-2a42-4a2a-9ac1-b7252889f5d0"><div style="font-size:1.5em"><img class="icon" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png"/></div><div style="width:100%"><code>optional</code>은 브라우저에게 웹 폰트 로드를 시도하되, 로드가 오래 걸리는 경우 시스템 폰트를 계속 사용하도록 지시합니다. 이 방법은 웹 폰트가 로드되기 전에 시스템 폰트가 보이는 시간을 최소화하므로, 웹 폰트 로딩으로 인한 레이아웃 변경을 방지할 수 있습니다.</div></figure></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">리덕스의 전역 상태관리 매커니즘이 새로고침 되면 초기화 되는 문제</summary><div class="indented"><h3 id="245a43dc-8926-4af9-8ee0-293d0d78da5c" class="">문제</h3><p id="f53b40b7-2c62-4533-84a6-4f044bda26f4" class="">로그인중, 로그인한 사용자의 정보를 useSelector에 값을 할당하여 전역적으로 관리할려고 했었다, 이렇게 하면 로그인한 사용자의 정보를 다양한 로직에 활용할려고 했었다.</p><p id="01b6b62a-be74-42b0-be21-c89229fb1491" class="">하지만 처음 실행 할떄는 기능이 잘 수행하지만, 새로고침(리다이렉트) 만 하면</p><p id="9c7e150d-ae30-4084-9c32-0734efd88aee" class="">useSelector에 담은 state들이 초기화되는 문제를 겪었다.</p><p id="2db01737-ceab-47ac-b98d-d4d046290951" class="">
</p><h3 id="7816da65-2a50-4ce6-928b-20ee9704dc80" class="">해결</h3><figure id="e41504b3-a27e-41eb-885d-2c1d9870a0d6"><a href="https://blog.logrocket.com/persist-state-redux-persist-redux-toolkit-react/" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">Persist state with Redux Persist using Redux Toolkit in React - LogRocket Blog</div><div class="bookmark-description">With Redux Persist, developers can save the Redux store in persistent storage so even after refreshing the browser, the site state will be preserved.</div></div><div class="bookmark-href"><img src="https://blog.logrocket.com/wp-content/uploads/2019/06/cropped-cropped-favicon-196x196.png?w=192" class="icon bookmark-icon"/>https://blog.logrocket.com/persist-state-redux-persist-redux-toolkit-react/</div></div><img src="https://blog.logrocket.com/wp-content/uploads/2022/06/persist-state-redux-persist-redux-toolkit-react.png" class="bookmark-image"/></a></figure><p id="659d781e-c50b-4c8d-ac0f-c88631dd5de5" class="">react-persist 라는 영속성을 지원하는 라이브러리를 설치한 후, 해결했다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="b98797fc-8167-4255-8f13-c818214fd1ca" class="code"><code class="language-undefined">import React from &quot;react&quot;;
import ReactDOM from &quot;react-dom/client&quot;;
// import &quot;./index.css&quot;;
import App from &quot;./App&quot;;
import reportWebVitals from &quot;./reportWebVitals&quot;;
import { BrowserRouter } from &quot;react-router-dom&quot;;
import { createGlobalStyle } from &quot;styled-components&quot;;
import GmarketSansTTFLight from &quot;./resources/GmarketSansTTFLight.ttf&quot;;
import WaveEffect from &quot;./components/WaveEffect&quot;;
import { configureStore } from &quot;@reduxjs/toolkit&quot;;
import rootReducer from &quot;./modules&quot;;
import logger from &quot;redux-logger&quot;;
import { Provider } from &quot;react-redux&quot;;
import &#x27;bootstrap/dist/css/bootstrap.min.css&#x27;;
import storage from &#x27;redux-persist/lib/storage&#x27;;
import persistReducer from &quot;redux-persist/es/persistReducer&quot;;
import { PersistGate } from &quot;redux-persist/integration/react&quot;;
import persistStore from &quot;redux-persist/es/persistStore&quot;;

const root = ReactDOM.createRoot(document.getElementById(&quot;root&quot;));
const GlobalStyle = createGlobalStyle`
@font-face {
    font-family: &#x27;GmarketSansTTFLight&#x27;;
    src: url(${GmarketSansTTFLight}) format(&#x27;truetype&#x27;);
    font-weight: normal;
    font-style: normal;
    font-display: &#x27;opional&#x27;;
}

#root {
    font-family: &#x27;GmarketSansTTFLight&#x27;, sans-serif;
    background: linear-gradient(to right, #89CFF0 0%, #B2FFFF 50%, #89CFF0 100%);
    justify-content: center;
    align-items: center;
    overflow-x: hidden;
    overflow-y: auto;
    position: relative;
}
`;

const persistConfig = {
  key: &#x27;root&#x27;,
  storage,
};
const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) =&gt; getDefaultMiddleware().concat(logger)
});

const persistor = persistStore(store);

root.render(
  &lt;BrowserRouter&gt;
    &lt;GlobalStyle /&gt;
    &lt;WaveEffect /&gt;
    &lt;Provider store={store}&gt;
      &lt;PersistGate loading={null} persistor={persistor}&gt;
        &lt;App /&gt;
      &lt;/PersistGate&gt;
    &lt;/Provider&gt;
  &lt;/BrowserRouter&gt;
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();</code></pre><p id="c18bd2a4-1ca0-418b-b6fc-a150e22b6746" class=""><br/><br/></p><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="cdab11e7-fd53-47be-b89b-4647e0660c83"><div style="font-size:1.5em"><img class="icon" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png"/></div><div style="width:100%"><code>redux-persist</code> 라이브러리는 Redux 상태를 브라우저의 로컬 스토리지 또는 세션 스토리지에 영속적으로 저장하기 위해 사용하는 라이브러리입니다.</div></figure><p id="7cf04864-1fce-4b0d-8e97-f6225383b71f" class="">
</p><h3 id="f61ad459-21c3-4b9f-bdfe-25cddb56fb93" class=""><code>persistConfig</code></h3><p id="3e22ebf5-74f9-4f6c-b909-771f14fbdeb6" class="">이는 <code>redux-persist</code>의 설정 객체입니다. 여기에서 &#x27;root&#x27;라는 키와 세션 스토리지를 사용하도록 설정하고 있습니다. 키는 스토리지에 저장될 때 사용되는 키를 나타내며, </p><p id="a02fe933-b355-45c7-9f46-439a35baccec" class=""><code>storage</code>는 사용할 스토리지 유형을 나타냅니다.</p><p id="781ea1d7-6fb9-4282-876c-820048a97382" class="">
</p><h3 id="f87ff185-5b0f-4fa8-81b0-34477b6e235c" class=""><code>persistedReducer</code></h3><p id="1a0502a4-102a-4562-b4bf-71e58608bc77" class=""><code>persistReducer</code> 함수는 <code>persistConfig</code>와 원래의 리듀서 (<code>rootReducer</code>)를 인자로 받아서 새로운 리듀서를 생성합니다. 이 리듀서는 원래의 리듀서와 동일한 방식으로 동작하지만, 추가적으로 액션이 디스패치되면 현재 상태를 스토리지에 저장하고, 앱이 시작될 때 스토리지에서 상태를 불러오는 기능을 가집니다.</p><p id="8d954cfe-4193-4aac-b898-516c02380510" class="">
</p><h3 id="4ec7f1cc-da1d-450f-aedf-f3bfb4849b81" class=""><code>store</code></h3><p id="4e5537ef-87ca-4d65-93e5-257103ee7a92" class="">이는 <code>configureStore</code> 함수를 사용하여 스토어를 생성합니다. 여기에서는 <code>persistedReducer</code>를 리듀서로 사용하고 있습니다. 이렇게 하면 스토어의 상태가 액션을 디스패치할 때마다 자동으로 스토리지에 저장됩니다.</p><p id="619adaa8-1fc2-4408-bde5-e9e278184b0b" class="">
</p><h3 id="b0ed668e-93ab-4b95-9447-254a6ba9b3e3" class=""><code>persistore</code></h3><p id="a04e19fd-2f95-4a7e-8468-d356eaa0cd51" class=""><code>persistStore</code> 함수는 스토어를 인자로 받아서 persistor 객체를 생성합니다. 이 객체는 <code>PersistGate</code> 컴포넌트에 필요합니다.</p><p id="c32879d8-22a5-4668-85b8-e435ed4fb3ce" class="">
</p><h3 id="eb8d6b14-b807-4b7f-9316-83274d688ea4" class=""><code>PersistGate</code></h3><p id="f5ad0542-f248-4b32-822f-f98cdfa1cbee" class="">이 컴포넌트는 앱이 시작될 때 스토리지에서 상태를 불러오는 동안 <strong>로딩 화면</strong>을 표시하도록 하는 역할을 합니다. 상태를 불러오는 작업이 완료되면 자식 컴포넌트를 렌더링합니다.  <code>PersistGate</code> </p><p id="0ce63579-3f51-4e1d-ad81-6a552c3a6eda" class="">컴포넌트의 <code>loading</code> prop에는 상태를 불러오는 동안 표시할 컴포넌트를 지정할 수 있습니다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">redux-persist 비직렬화 액션 값 오류 - JJY</summary><div class="indented"><h3 id="72162ca3-8e3f-4ebc-88e5-84e997addbe2" class="">오류 발견</h3><p id="ef18f720-7810-4df0-99e6-f6620489bb59" class="">리액트 앱 실행시 콘솔창에 다음과 같은 오류 로그가 나타납니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="32575392-a039-4c4c-966d-2bccfc701507" class="code"><code class="language-Java">A non-serializable value was detected in an action, in the path: `register`. Value: ƒ register(key) {
    _pStore.dispatch({
      type: _constants__WEBPACK_IMPORTED_MODULE_2__[&quot;REGISTER&quot;],
      key: key
    });
  }</code></pre><h3 id="bd06dcb6-eb1c-4a3c-bdf4-68bd8a8dd0e5" class="">오류 원인</h3><p id="0e3f0418-13ba-4bd5-9d70-560f33555665" class="">로그만 보면redux는 state, action에 직렬화가 불가능한 값을 전달할 수 없어 발생하는 오류입니다.<br/>하지만 기능은 정상적으로 작동합니다.<br/>더 찾아본 결과, redux-persist의 고유 문제인것 같습니다. <br/></p><figure id="209893e3-58da-49ee-97fa-c7c89898169b"><a href="https://github.com/rt2zz/redux-persist/issues/988" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">non-serializable value error · Issue #988 · rt2zz/redux-persist</div><div class="bookmark-description">Hi folks 👋, I just installed the redux-persist in a project still in its early stages and I&amp;#39;m facing this error message in the console as first thing when the page loads. I haven&amp;#39;t done muc...</div></div><div class="bookmark-href"><img src="https://github.com/fluidicon.png" class="icon bookmark-icon"/>https://github.com/rt2zz/redux-persist/issues/988</div></div><img src="https://opengraph.githubassets.com/19e4b93a5acc07488d89a27fb858d90592dd9faebab89fb409a370dbd8dd28fa/rt2zz/redux-persist/issues/988" class="bookmark-image"/></a></figure><p id="7533d051-44b5-452b-a13b-a4d115e486ab" class="">persist의 몇가지 액션들에서 발생하는 오류였습니다. redux toolkit 공식 문서에서도 이에 대한 설정을 추가해 놓았습니다.</p><figure id="1091ffeb-af10-4d54-b388-9e7a768813a2"><a href="https://redux-toolkit.js.org/usage/usage-guide#use-with-redux-persist" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">Usage Guide | Redux Toolkit</div><div class="bookmark-description">&amp;nbsp;</div></div><div class="bookmark-href"><img src="https://redux-toolkit.js.org/img/favicon/favicon.ico" class="icon bookmark-icon"/>https://redux-toolkit.js.org/usage/usage-guide#use-with-redux-persist</div></div><img src="https://redux-toolkit.js.org/img/redux-logo-landscape.png" class="bookmark-image"/></a></figure><h3 id="5902525a-ac0e-4e1d-9841-b7ff114f1cd6" class="">오류 해결</h3><p id="55b07581-a7f5-4212-9d07-c8d6b3b4a04c" class="">persist의 몇몇 액션들에 대해서 직렬화 체크를 무시하도록 설정하면 됩니다.</p><p id="1da2a8a7-383c-445a-93dd-75dd6a3af76f" class="">configureStore를 다음과 같이 수정합니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="a0fc9c25-c46b-467c-808f-322c5a251d00" class="code"><code class="language-JavaScript">import {
  FLUSH,
  REHYDRATE,
  PAUSE,
  PERSIST,
  PURGE,
  REGISTER,
} from &quot;redux-persist&quot;;

...

const store = configureStore({
  reducer: persistedReducer,
  devTools: process.env.NODE_ENV !== &quot;production&quot;,
  middleware: (getDefaultMiddleware) =&gt;
    getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER],
      },
    }).concat(sagaMiddleware, logger),
});</code></pre></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">axios 요청 주소 403 에러 문제 - JJY</summary><div class="indented"><h3 id="37c0a229-0443-457f-bc41-6db80b95fff7" class="">오류 발견</h3><p id="ff5347ff-9a96-42c7-a8fe-c4cedffeae74" class="">id값으로 grammarbook을 가져오는 axios GET 요청에서 403 에러가 발생했습니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="51aa0f33-fc28-4248-a995-80e89a8e3b14" class="code"><code class="language-JavaScript">export const getGrammarBookById = async (id) =&gt; {
  const response = await axios.get(`api/grammarbook/${id}`);
  return response.data;
};</code></pre><p id="b416bd21-3548-454b-8651-c5376b104ca5" class="">http://localhost:3000/grammarbooks/api/grammarbook/{id}로 요청을 보내고 있었고, 백엔드에서 열어둔 요청 주소는 http://localhost:3000/api/grammarbook/{id}여서 AxiosError {message: &#x27;Request failed with status code 403&#x27;, name: &#x27;AxiosError&#x27;, code: &#x27;ERR_BAD_REQUEST&#x27;, config: {…}, request: XMLHttpRequest, …}가 발생했습니다.</p><h3 id="fcbdb1ad-0180-4ce7-9232-d1ec2f6e9c01" class="">오류 원인</h3><p id="75cdf3fd-7649-4613-91cf-fdc3f47792d0" class="">아주 단순한 오류입니다. axios의 요청 주소에 상대경로를 지정했기 때문입니다. </p><p id="7a8de622-b7eb-48af-a0b6-8437e0ab15c4" class="">+ 403 오류 원인은 매우 다양합니다. 이 경우는 잘못된 경로로 요청을 보냈기 때문입니다.</p><p id="e5195556-8c51-4002-8e04-127213ce1fa7" class=""><strong>요청 주소가 </strong><strong><code>/</code></strong><strong>로 시작하지 않으면 axios는 현재 페이지에 요청 주소를 붙여서 요청을 날립니다.</strong></p><h3 id="50e080cb-ca0f-4f92-b633-635e1ef061d4" class="">오류 해결</h3><p id="5b81b1f1-3400-4d5c-8a2e-243267f10f4e" class="">요청 주소에 <code>/</code>만 붙여주면 정상적으로 작동합니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="bc0ad37c-2dad-49f2-ac95-3d1df01f3f29" class="code"><code class="language-JavaScript">export const getGrammarBookById = async (id) =&gt; {
  const response = await axios.get(`/api/grammarbook/${id}`);
  return response.data;
};</code></pre><p id="16569c76-955f-4f50-b2a9-900ad9bbd4b6" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">클라이언트가 DB에 없는 데이터를 요청하는 문제 - JJY</summary><div class="indented"><h3 id="00f15765-28c4-4aec-b8df-de41eebe3241" class="">오류 발견</h3><p id="89d60e19-aceb-400f-b407-b0481179f392" class="">URL 파라미터에서 파싱한 grammarbook의 id로 해당 id를 가진 grammarbook을 요청하는 API가 있었습니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="07caa160-f70e-4efb-b4c0-882988042c2b" class="code"><code class="language-JavaScript">export const getGrammarBookById = async (id) =&gt; {
  const response = await axios.get(`/api/grammarbook/${id}`);
  return response.data;
};</code></pre><p id="f58dd309-c3a6-42c1-b203-f7d01980d34e" class="">백엔드에서 테스트를 하다가 기존에 존재하던 grammarbook을 지우고 새로 생성했습니다.<br/>그래서 리액트가 당연히 새로 생성된 grammarbook의 id로 요청할거라 생각했지만, 이미 삭제된 grammarbook의 id로 요청해 데이터를 받아오지 못했습니다.<br/></p><h3 id="fc44fe25-6a10-4339-9f22-c5f2c39a1729" class="">오류 원인</h3><p id="f5c2e790-9a5c-41b4-91c1-6d708444f0b2" class="">redux-persist가 상태값을 브라우저 로컬 스토리지에 저장하도록 설정했기 때문이라고 추정합니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="5e685951-19c3-4f7b-86ec-d5a4acb2b328" class="code"><code class="language-JavaScript">import storage from &quot;redux-persist/lib/storage&quot;;
...
const persistConfig = {
  key: &quot;root&quot;,
  storage, //로컬 스토리지에 state 저장
};</code></pre><h3 id="cd51c9f8-0688-4754-877a-1930a36653ac" class="">오류 해결</h3><p id="7bf2da5a-f1ee-433d-8cb7-3e543cdc40f5" class="">grammarbook의 이름은 거의 바뀌지 않을 것이므로 id대신 grammarBookName으로 변경했습니다.</p><p id="40d1fc8e-5c27-47f9-9add-e8058ee211bf" class="">이에따라 URL 파싱을 grammarBookName으로 해오기 위해 라우트도 수정했습니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="3ab50016-1176-46e7-a449-6f1dba1705c9" class="code"><code class="language-JavaScript">export const getGrammarBookById = async (grammarBookName) =&gt; {
  const response = await axios.get(`/api/grammarbook/${grammarBookName}`);
  return response.data;
};</code></pre><p id="566e8cbd-006a-41de-acc6-4d309c26c1de" class="">같은 grammarBookName이 수정된다면 어떻게 될지 살펴볼 필요가 있습니다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">axios 객체 직렬화 오류 ✨✨</summary><div class="indented"><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="601ccc8f-056b-40bd-9610-79c073ceaa5d" class="code"><code class="language-Plain Text">A non-serializable value was detected in an action, in the path: `payload.headers`. Value: AxiosHeadersaccess-control-allow-headers: &quot;*&quot;access-control-allow-methods: &quot;*&quot;access-control-allow-origin: &quot;*&quot;cache-control: &quot;no-cache, no-store, max-age=0, must-revalidate&quot;connection: &quot;close&quot;content-encoding: &quot;gzip&quot;content-type: &quot;application/json&quot;date: &quot;Wed, 07 Feb 2024 08:22:42 GMT&quot;expires: &quot;0&quot;pragma: &quot;no-cache&quot;transfer-encoding: &quot;chunked&quot;vary: &quot;Accept-Encoding&quot;x-content-type-options: &quot;nosniff&quot;x-frame-options: &quot;SAMEORIGIN&quot;x-powered-by: &quot;Express&quot;x-xss-protection: &quot;0&quot;clear: (...)concat: (...)constructor: (...)delete: (...)get: (...)getAccept: (...)getAcceptEncoding: (...)getAuthorization: (...)getContentLength: (...)getContentType: (...)getUserAgent: (...)has: (...)hasAccept: (...)hasAcceptEncoding: (...)hasAuthorization: (...)hasContentLength: (...)hasContentType: (...)hasUserAgent: (...)normalize: (...)set: (...)setAccept: (...)setAcceptEncoding: (...)setAuthorization: (...)setContentLength: (...)setContentType: (...)setUserAgent: (...)toJSON: (...)toString: (...)Symbol(Symbol.toStringTag): (...)[[Prototype]]: Object 
Take a look at the logic that dispatched this action:</code></pre><p id="1f211ad9-bfb5-4c2f-a03e-aac8546c9420" class="">위에서 제시된 오류는 <code>Axios</code> 요청의 결과로 받은 <code>headers</code> 객체가 <code>Redux</code> 상태로 저장되면서 발생하는 것으로 보입니다. <code>Axios</code> 요청의 결과 객체는 <code>data</code>, <code>status</code>, <code>statusText</code>, <code>headers</code>, <code>config</code> 등 여러가지 속성을 가지고 있는데, 그 중 <code>data</code>만이 우리가 직접적으로 사용하는 API 응답 결과다.<strong><br/><br/></strong></p><h3 id="6edc40ce-e84a-43a2-b210-6e7a00eba123" class="">해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="273e2834-d59f-4fcf-aef6-736c1396242d" class="code"><code class="language-JavaScript">export async function getVocaBooksAPI() {
  const response = await axios.get(&#x27;/api/vocabooks&#x27;);
  return response.data; // data 속성만 반환합니다.
}</code></pre><p id="2f700f3f-c377-4b4b-a66d-3e8640199afb" class="">response에 data객체를 추가했다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">redux null오류</summary><div class="indented"><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="4cf84c3a-0c9d-4f6e-aeaa-087ffecc35af"><div style="font-size:1.5em"><span class="icon">💡</span></div><div style="width:100%"><strong>개발자 실수 : redux 문법 오류 </strong></div></figure><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="e1316e5b-b8a4-4281-b7ce-ca1aee73ba73" class="code"><code class="language-SQL">yield all([call(vocaSaga)]);
  yield all([call(vocaBookSaga)]);</code></pre><p id="b2ad22bf-044b-405b-b1b4-d5cb8c2bbd11" class="">rootsaga를<br/><br/><br/></p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="9f2e7206-f7e9-455f-b6b5-4d56593294d3" class="code"><code class="language-SQL">import createSagaMiddleware from &quot;redux-saga&quot;;
import { all, call } from &quot;redux-saga/effects&quot;;
import vocaBookSaga from &quot;./voca/vocaBookSaga&quot;;
import vocaSaga from &quot;./voca/vocaSaga&quot;;

const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield all([call(vocaSaga), call(vocaBookSaga)]);
}

export default sagaMiddleware;</code></pre><p id="50c1cfd8-f5e1-4244-b231-c136af19cacf" class="">이 방식으로 수정하니 되었다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0"><strong>cannot update a component (&#x27;...&#x27;) while rendering a different component (&#x27;...&#x27;) - JJY</strong></summary><div class="indented"><p id="8dc75af1-9b05-46d8-8e5f-5ee4ab31af9b" class=""><code>다른 컴포넌트를 랜더링하는 도중에 컴포넌트를 업데이트 할 수 없다</code>는 경고입니다.<br/><br/></p></div></details><p id="40fdcb3c-5a92-41c8-9a72-314805d127c1" class="">
</p><h2 id="4a92b6b8-7792-4e26-a992-1a627f0464f9" class="">보안</h2><hr id="f6354ca0-aa04-4fed-b27e-df71b18eb6de"/><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">CD단계에서 주의점</summary><div class="indented"><figure id="2b1cfe10-1417-4734-ad0a-99a8d0b6b236"><a href="https://leveloper.tistory.com/38" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">[스프링] 배포용 서버에 데이터베이스 Schema 및 Data 초기 설정하기</div><div class="bookmark-description">스프링 부트로 개발을 할 때 보통 개발단계에서는 h2를 많이 사용한다. 또한 JPA를 사용하면 하이버네이트가 자동으로 테이블을 생성해주기 때문에 개발 단계에서는 DDL을 신경 쓸 필요가 없다. 하지만 실제 배포 단계에서는 하이버네이트가 자동으로 생성해주는 sql을 사용하는 것은 위험하다. 따라서 spring.jpa.hibernate.ddl-auto을 none으로 설정하고 schema.sql을 작성해주는 편이 좋다. profile 파일 분리 우선 배포용 서버에서 사용하는 profile 파일이랑 개발 단계에서 사용하는 profile 파일을 분리해야 한다. application.yml에서는 dev profile을 활성화시켜주고, 배포할 때는 스크립트 파일에서 따로 real profile을 활성화시켜줄 것이다...</div></div><div class="bookmark-href"><img src="https://leveloper.tistory.com/favicon.ico" class="icon bookmark-icon"/>https://leveloper.tistory.com/38</div></div><img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fimages%2FopenGraph%2Fopengraph.png" class="bookmark-image"/></a></figure><ul id="cefa14ae-2b03-47c5-9121-d5c26fc1b891" class="bulleted-list"><li style="list-style-type:disc">요약 : 배포 단계에서 Hibernate SQL 보여주는 부분을 none으로 처리한다.</li></ul></div></details><details open=""><summary style="font-weight:600;font-size:1.5em;line-height:1.3;margin:0">메소드내에 매개변수를 들고올떄는..</summary><div class="indented"><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="158b19ba-10dc-455d-aab9-5411d13872a5"><div style="font-size:1.5em"><img class="icon" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24%201.png"/></div><div style="width:100%"><strong>요약 :</strong> <code>final</code>로 선언된 객체는 메소드 내에서 변경되지 않으므로, <strong>예기치 않은 사이드 이펙트(side effect)나 데이터 변조를 방지</strong>할 수 있다.</div></figure><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="b395641e-089f-471e-a34b-fc42d0cbee54" class="code"><code class="language-Java">package com.wordwave.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
	private UserRepository userRepository;
	
	public SiteUser create(final SiteUser user) {
		if(user == null || user.getUserName() == null) {
			throw new RuntimeException(&quot;Invalid arguments&quot;);
		}
		final String userName = user.getUserName();
		if(userRepository.existsByUserName(userName)) {
			log.warn(&quot;UserName is already exists {}&quot;,userName);
			throw new RuntimeException(&quot;UserName is already exists&quot;);
		}
		
		return userRepository.save(user);
	}
	
}</code></pre><p id="e49350cb-d38a-4cb6-bb88-74058d0bc2ea" class=""><code>final</code> 키워드를 사용하여 메소드의 매개변수를 선언하는 것은, <strong>그 매개변수가 메소드 내에서 변경되지 않도록 하는 것</strong>입니다. </p><p id="817526ae-f9e5-4744-9098-19497813c084" class="">이는 특히 중요한 객체나 엔티티를 다루는 경우에 유용할 수 있습니다. 왜냐하면, 이런 방식으로 코드를 작성하면, 해당 객체의 상태가 예기치 않게 변경되는 것을 방지할 수 있기 때문입니다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.5em;line-height:1.3;margin:0">CSRF 설정</summary><div class="indented"><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="f2bab6ad-d80b-4df9-a0ba-85c702e9743b" class="code"><code class="language-Java">package com.wordwave;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
	        .csrf().disable()
	        .authorizeHttpRequests((authorizeHttpRequests) -&gt; authorizeHttpRequests
	            .requestMatchers(new AntPathRequestMatcher(&quot;/**&quot;)).permitAll())
	        .headers((headers) -&gt; headers
	                    .addHeaderWriter(new XFrameOptionsHeaderWriter(
	                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
            
        ;
        return http.build();
    }
    

}</code></pre><p id="3a342455-10bb-4208-88a7-557d228a959c" class="">CI 단계에는, 해당 설정을 비활성화 했으나,</p><p id="890db5c9-16a9-4c47-be5b-33248f7f1759" class=""><strong>CD단계에서는 활성화 해야함!</strong></p><figure id="90fc4d4f-5b4f-4f65-a90b-2cd8483e3cdd"><a href="https://velog.io/@letsdev/Spring-Boot-3.1Spring-6.1-Security-Config-csrf-is-deprecated-and-marked-for-removal" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">Spring Boot 3.1(Spring 6.1) Security Config: &#x27;csrf()&#x27; is deprecated and marked for removal</div><div class="bookmark-description">스프링 부트 3.1로 올리면서 발생하는 Deprecated 문제가 있다. 기존 Security Configuration 자바 소스 코드에서 서로 무관한 애들끼리도 직렬로 이어지던 이런 메서드 체이닝을 지양하고, 함수형으로 전달하여 설정하면 된다. 코드는 ...</div></div><div class="bookmark-href"><img src="https://static.velog.io/favicons/apple-icon-152x152.png" class="icon bookmark-icon"/>https://velog.io/@letsdev/Spring-Boot-3.1Spring-6.1-Security-Config-csrf-is-deprecated-and-marked-for-removal</div></div><img src="https://velog.velcdn.com/images/letsdev/post/44b40f1f-4d13-46ea-8ca7-e98541c13a9a/image.png" class="bookmark-image"/></a></figure><p id="4c313550-4e32-43b3-9bc3-a257f1834cba" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">Spring Security 6.2.0에서 <strong>is deprecated and marked for removal 경고 - JJY</strong></summary><div class="indented"><h3 id="df6b93b0-7b76-4785-8074-3f4c359fc78c" class="">오류 발견</h3><p id="6b92fa57-01c5-443d-9919-9de8fca9c5d0" class="">스프링부트 빌드(애플리케이션 실행)시 다음과 같은 경고가 발생합니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="7f9cb158-4c4d-4ce6-9175-381ddeec32ab" class="code"><code class="language-Plain Text">C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:35: warning: [removal] cors() in HttpSecurity has been deprecated and marked for removal
        http.cors()
            ^
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:36: warning: [removal] and() in SecurityConfigurerAdapter has been deprecated and marked for removal
            .and()
            ^
  where B,O are type-variables:
    B extends SecurityBuilder&lt;O&gt; declared in class SecurityConfigurerAdapter
    O extends Object declared in class SecurityConfigurerAdapter
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:37: warning: [removal] httpBasic() in HttpSecurity has been deprecated and marked for removal
            .httpBasic().disable()
            ^
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:38: warning: [removal] sessionManagement() in HttpSecurity has been deprecated and marked for removal
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ^
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:39: warning: [removal] and() in SecurityConfigurerAdapter has been deprecated and marked for removal
            .and()
            ^
  where B,O are type-variables:
    B extends SecurityBuilder&lt;O&gt; declared in class SecurityConfigurerAdapter
    O extends Object declared in class SecurityConfigurerAdapter
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:40: warning: [removal] authorizeHttpRequests() in HttpSecurity has been deprecated and marked for removal
            .authorizeHttpRequests()
            ^
Note: Some input files use or override a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
7 warnings</code></pre><h3 id="2f3bb3d6-5e53-4b46-bdca-71f97c6f1565" class="">오류 원인</h3><p id="98ebf383-1e9a-482f-93df-13df05f35878" class="">spring security 6.0이하 버전에서 사용된 메서드들이 6.1이상 버전부터는 deprecated되며 제거 대상이 되었습니다.</p><p id="496585db-7813-47dc-bf8b-d480b557fad1" class="">이는 6.1버전부터 메서드 체이닝을 지양하고 함수형 프로그래밍을 지향하기 때문입니다. 본래 함수형 방식을 지원했지만 사람들이 잘 안썼다고 합니다.</p><h3 id="5546c5d4-4243-4ec3-a6ac-2dccc3077845" class="">오류 해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="ad80dce0-5d0b-476f-8517-b30b97bd4d9e" class="code"><code class="language-Java">http.cors()
		.and()
		.httpBasic().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeHttpRequests()
		.requestMatchers(&quot;/&quot;, &quot;/api/**&quot;,&quot;/h2-console/**&quot;).permitAll()
		.requestMatchers(new AntPathRequestMatcher(&quot;/**/*.html&quot;)).permitAll()
		.requestMatchers(new AntPathRequestMatcher(&quot;/**/*.css&quot;)).permitAll()
		.requestMatchers(new AntPathRequestMatcher(&quot;/**/*.js&quot;)).permitAll()
		.anyRequest().authenticated();</code></pre><p id="783ab682-1091-4b17-a216-11cfc8beb735" class="">위 코드는 <code>SecurityConfig</code> 클래스에 있는 <code>SecurityFilterChain</code> 설정의 일부입니다.</p><p id="9937fe13-f8d6-46f5-8110-2edeff121fa2" class="">위에서 deprecated 부분은 <code>cors()</code>, <code>and()</code>, <code>httpBasic()</code>, <code>sessionManagement()</code>, <code>authorizeHttpRequests()</code>입니다.</p><p id="c327aaec-bc55-4db2-9b78-f24db83187fb" class="">이를 아래와 같이 수정할 수 있습니다.</p><p id="0734b2d0-e8fd-4475-bc10-674345612c2a" class="">+resources디렉터리에 있는 이미지들을 못불러와서 requestMatchers에 <code>&quot;/static/**&quot;</code>경로를 추가했습니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="a0c931a5-2626-44a0-b27b-6cce75e04de9" class="code"><code class="language-Java">http.cors(AbstractHttpConfigurer::disable)
		.httpBasic(HttpBasicConfigurer::disable)
		.sessionManagement(sessionManagement -&gt; sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(authorizeHttpRequests -&gt; authorizeHttpRequests
		        .requestMatchers(&quot;/&quot;, &quot;/api/**&quot;,&quot;/h2-console/**&quot;, &quot;/static/**&quot;).permitAll()
		        .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.html&quot;)).permitAll()
		        .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.css&quot;)).permitAll()
		        .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.js&quot;)).permitAll()
		        .anyRequest().authenticated());</code></pre><p id="0eda3337-5ae5-42a2-b88a-ad3a4948413a" class="">
</p><hr id="6fdf0b55-f2c0-46ce-8bd9-dad7d3d59076"/><h3 id="1d01f5b8-6d79-4b3f-813b-164e6ef21bb0" class="">비슷한 오류 발견</h3><p id="073e568b-97a5-4b10-9c50-e313f128f402" class="">SecurityConfig 클래스에 지정한 <code>@EnableGlobalMethodSecurity(prePostEnabled = true)</code>에 아래와 같이 deprecated 경고가 발생합니다.</p><p id="9c51b2f0-9110-44ba-9f10-c2373db31853" class="">&#x27;org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity&#x27; is deprecated</p><h3 id="313154e0-0776-4126-a881-e8487012ae3f" class="">오류 해결</h3><p id="82b06186-9494-4a20-8ce3-7e1cabb3b541" class=""><code>@EnableGlobalMethodSecurity</code>대신 <code>@EnableMethodSecurity</code>를 사용하면 됩니다. 그리고<code>prePostEnabled = true</code>를 지정할 필요 없습니다. 왜냐하면 기본값이 true이기 때문입니다.</p><p id="d8d8ff86-49cf-4c97-b28b-a6af9c0a8e3f" class="">참고)</p><figure id="8dcafa95-a29f-4aa4-84ff-26f85496a19d"><a href="https://stackoverflow.com/questions/74910066/enableglobalmethodsecurity-is-deprecated-in-the-new-spring-boot-3-0" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">@EnableGlobalMethodSecurity is deprecated in the new spring boot 3.0</div><div class="bookmark-description">I use Spring Boot 3.0, and when I work on security configuration, I get a warning that the @EnableGlobalMethodSecurity is deprecated.
@Configuration
@EnableWebSecurity
@AllArgsConstructor
@</div></div><div class="bookmark-href"><img src="https://cdn.sstatic.net/Sites/stackoverflow/Img/apple-touch-icon.png?v=c78bd457575a" class="icon bookmark-icon"/>https://stackoverflow.com/questions/74910066/enableglobalmethodsecurity-is-deprecated-in-the-new-spring-boot-3-0</div></div><img src="https://cdn.sstatic.net/Sites/stackoverflow/Img/apple-touch-icon@2.png?v=73d79a89bded" class="bookmark-image"/></a></figure></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">효율적인 정적자원 인증 - JJY</summary><div class="indented"><figure id="d1a7e210-a91e-4eaf-9c4f-b59c00e33c6a"><a href="https://velog.io/@yevini118/Spring-Security-정적-자원-ignore하기" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">[Spring Security] 정적 자원 ignore하기</div><div class="bookmark-description">Spring Security를 적용하고 정적 자원들이 적용되지 않는 문제가 발생하였다..!  (사라져버린 이미지와 css...)  콘솔에는 다음과 같은 에러가 떠있었다 &gt; Refused to apply style from &#x27;http://localhost:8080/&#x27; b</div></div><div class="bookmark-href"><img src="https://static.velog.io/favicons/apple-icon-152x152.png" class="icon bookmark-icon"/>https://velog.io/@yevini118/Spring-Security-정적-자원-ignore하기</div></div><img src="https://images.velog.io/velog.png" class="bookmark-image"/></a></figure><p id="461b6b27-54d8-45c4-b004-f1ad12b01f21" class="">위 포스트에서는 <strong>필터를 거치는 </strong><strong><code>permitAll()</code></strong><strong>보다 필터를 거치지 않는</strong><strong><code>ignore()</code></strong><strong>가 효율적</strong>이라고 합니다. 왜그런지는 공부가 더 필요할 것 같습니다.</p><p id="1a044097-13e1-46dc-81dc-063c264904c4" class="">일단 아래처럼 적용할 수 있겠습니다. 일부 json과 ico가 frontend/build/에 들어있어 static/** 경로에서 못찾는 오류가 발생해 따로 경로를 추가했습니다.</p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="e9945fa5-a0c6-4463-87d9-91d67c6362f3" class="code"><code class="language-Java" style="white-space:pre-wrap;word-break:break-all">package com.wordwave.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableMethodSecurity
public class SecurityConfig {
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http
        .csrf(AbstractHttpConfigurer::disable)
        .headers((headers) -&gt; headers
            .addHeaderWriter(new XFrameOptionsHeaderWriter(
                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)));

        http.cors(AbstractHttpConfigurer::disable)
            .httpBasic(HttpBasicConfigurer::disable)
            .sessionManagement(sessionManagement -&gt; sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorizeHttpRequests -&gt; authorizeHttpRequests
                    .requestMatchers(&quot;/&quot;, &quot;/api/**&quot;).permitAll()
                    .anyRequest().authenticated());
        
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
        
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -&gt; web.ignoring()
                .requestMatchers(new AntPathRequestMatcher(&quot;/h2-console/**&quot;))
                .requestMatchers(new AntPathRequestMatcher(&quot;/static/**&quot;))
                .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.html&quot;))
                .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.css&quot;))
                .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.js&quot;))
                .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.json&quot;))
                .requestMatchers(new AntPathRequestMatcher(&quot;/**/*.ico&quot;));
    }
}</code></pre><h2 id="9f717f64-dd17-4f74-b029-8af082781d40" class="">이유 : 메서닝체이닝 → 함수형문법으로 변경 (성능 시점)</h2><p id="5241c2ea-d612-4b1b-a1e3-1217ac91f6ac" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">jwt 메서드 deprecated 경고 - JJY</summary><div class="indented"><h3 id="e258de95-4658-4f68-9383-d600f32dda35" class="">오류 발견</h3><p id="ad98c287-0869-4d10-85e3-84333ffc2d08" class="">security &gt; TokenProvider.java에서 총 3개의 deprecated 경고를 발견했습니다.</p><ul id="ca0f6056-bd43-42d5-9ac2-6e7786094832" class="bulleted-list"><li style="list-style-type:disc"><code>signWith</code>: <em>&#x27;signWith(io.jsonwebtoken.SignatureAlgorithm, java.lang.String)&#x27; is deprecated</em></li></ul><ul id="8cbd4e18-bee4-4830-9549-392c8f0b8241" class="bulleted-list"><li style="list-style-type:disc"><code><em>parser</em></code><em>: &#x27;parser()&#x27; is deprecated</em></li></ul><ul id="772f72d9-ef83-4ec5-96eb-9397ffb01bfa" class="bulleted-list"><li style="list-style-type:disc"><code>setSigningKey</code>: <em>&#x27;setSigningKey(java.lang.String)&#x27; is deprecated</em></li></ul><h3 id="5796141a-7a4d-48d7-8b68-c7ce245ccea1" class="">오류 원인</h3><p id="f9df51b5-73d2-4130-8de3-c853387043f2" class=""><strong>문자열 혹은 바이트를 인수로 받는</strong> <code>signWith</code>메서드는 안전하지 않은 원시적인 암호 문자열을 키 인수로 사용하기 때문에 deprecated 대상이라고 합니다. <code>setSigningKey</code>도 비슷한 이유인 것 같습니다.</p><h3 id="cb4c4e69-67f7-42b3-9f06-99cedc46c633" class="">오류 해결</h3><p id="24951d7f-89ca-4e38-90e5-40482af17ec2" class="">아래 예시처럼 Key객체를 <code>signWith</code>의 인수로 넣어주면 됩니다. 이때, Key 알고리즘은 Key객체를 생성할때 넣어주거나 <code>signWith</code>의 두번째 인자로 넣어줘도 됩니다. </p><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="07c60b31-291c-4d8a-a9be-a61ff66aaa0f" class="code"><code class="language-Java">private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
 
return Jwts.builder()
		// header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
		// payload에 들어갈 내용
		.signWith(key)
		.setSubject(userEntity.getId()) // sub
		.setIssuer(&quot;demo app&quot;) // iss
		.setIssuedAt(new Date()) // iat
		.setExpiration(expiryDate) // exp
		.compact();</code></pre><p id="2978c655-5d6d-4467-850a-e5163b36adc4" class="">
</p><p id="5ae49253-4828-4664-9bfb-0870afcd0738" class=""><code>parser</code>와 <code>setSigningKey</code>는 아래 예시처럼 수정하면 됩니다.</p><ul id="d50d62d2-6a5e-46a3-94e8-cb8b87d7474c" class="bulleted-list"><li style="list-style-type:disc"><code>parser</code> → <code>parserBuilder</code>로 변경</li></ul><ul id="b9300987-89f1-4aa6-b2f4-39927b11b437" class="bulleted-list"><li style="list-style-type:disc"><code>setSigningKey</code>에 문자열 대신 Key객체 넣기</li></ul><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="39b2f60c-e8f7-4bd2-b97d-a0c5b1be9365" class="code"><code class="language-Java">Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();</code></pre><p id="2ae3957b-98df-4010-a8d4-e3ccd5fe7fda" class="">
</p><p id="3dac06d5-f8e5-47ec-9960-a9b715a47e0d" class="">자세한 수정 방법은 아래 포스트를 참고하기 바랍니다.</p><figure id="d4a0cd50-9ccf-478e-8cbd-2f1d7705f560"><a href="https://leeeehhjj.tistory.com/61" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">jwt signWith deprecated 오류</div><div class="bookmark-description">String key; public JwtTokenProvider(@Value(&quot;${jwt.secret}&quot;) String secretKey) { key = Base64.getEncoder().encodeToString(secretKey.getBytes()); } public TokenInfoResponseDto generateToken(Authentication authentication) { ... //AccessToken 생성 Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME); String accessToken = Jwts.builder() .setSubject(authentication.getName()) .claim(AUTHO..</div></div><div class="bookmark-href"><img src="https://t1.daumcdn.net/tistory_admin/favicon/tistory_favicon_32x32.ico" class="icon bookmark-icon"/>https://leeeehhjj.tistory.com/61</div></div><img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fimages%2FopenGraph%2Fopengraph.png" class="bookmark-image"/></a></figure><figure id="fabddc8d-4fc2-45dc-9969-2ca24ac8031e"><a href="https://erjuer.tistory.com/87" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">[JWT] Spring Boot 환경에서 JWT(Json Web Token)생성 하기</div><div class="bookmark-description">첫번째의 JWT는 JWT에 대한 간단한 설명을 정리했고 2번째는 Spring Boot 환경에서 JWT를 직접 생성해보고자 한다. 사실 JWT 생성은 https://jwt.io/ JWT.IO JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties. jwt.io 해당 홈페이지에서 직접 PayLoad값을 넣어가며 생성할 수 있다. 하지만 실무 백엔드에서 JWT를 활용할 수 있는 간단한 JWT 생성코드를 정리해 보고자한다. 생성에는 jjwt 플러그인을 활용하였다. 1. build.gradle 설정에 io.jsonwebtoken:jjwt 플러그인을 추가한다. im..</div></div><div class="bookmark-href"><img src="https://t1.daumcdn.net/tistory_admin/favicon/tistory_favicon_32x32.ico" class="icon bookmark-icon"/>https://erjuer.tistory.com/87</div></div><img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&amp;fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FwFxvh%2FbtriTv8QSkz%2FkZEo7ad60lKPxtvVJFqT6k%2Fimg.png" class="bookmark-image"/></a></figure><p id="cdebb0f8-5853-4773-820e-32de27c778af" class="">
</p><figure id="879ed530-7e5e-42fc-8874-13b0aaa5f346"><a href="https://lenagend.tistory.com/17" class="bookmark source"><div class="bookmark-info"><div class="bookmark-text"><div class="bookmark-title">JJWT signWith deprecated 오류해결</div><div class="bookmark-description">문제상황-&gt; public String create(UserEntity userEntity) { // 기한 지금으로부터 1일로 설정 Date expiryDate = Date.from( Instant.now() .plus(1, ChronoUnit.DAYS)); // JWT Token 생성 return Jwts.builder() // header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY // payload에 들어갈 내용 .signWith(SignatureAlgorithm.HS512, &quot;abcde&quot;) .setSubject(userEntity.getId()) // sub .setIssuer(&quot;demo app&quot;) // iss .setIssuedAt(new Date()) // iat .setExpira..</div></div><div class="bookmark-href"><img src="https://lenagend.tistory.com/favicon.ico" class="icon bookmark-icon"/>https://lenagend.tistory.com/17</div></div><img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&amp;fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FBYfn6%2FbtrWwqhd5yP%2FYLOWdXRCllZuIdiPpRmpn0%2Fimg.png" class="bookmark-image"/></a></figure><p id="dddffba7-e06b-499c-89fd-d00b3d789ae1" class="">AJN 추가</p><p id="7765b6da-1edd-4f02-947c-091da154ab22" class="">
</p><p id="18efeac3-16a9-4927-8840-3faeb02f9c66" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0"><strong>&quot;Authorization&quot;이라는 헤더를 axios의 기본 헤더에 추가하는 이유</strong></summary><div class="indented"><p id="c9179e59-98ff-4d2b-9690-a443778f7880" class="">&quot;Authorization&quot;이라는 헤더를 axios의 기본 헤더에 추가하는 이유는, 서버에 요청을 보낼 때마다 해당 요청이 인증된 요청임을 서버에게 알리기 위함입니다.</p><p id="398d80f3-76e5-47d6-9b1e-6c64c2f5f59a" class="">JWT 토큰을 사용하는 경우, 사용자가 로그인을 하면 서버에서 JWT 토큰을 발급해줍니다. 이 토큰은 사용자의 인증 정보를 담고 있으며, 이를 사용자가 서버에 요청을 보낼 때마다 이 토큰을 요청 헤더에 포함시켜서 보내게 됩니다. 이렇게 하면 서버는 헤더에 포함된 토큰을 확인하여 해당 요청이 유효한 요청인지를 판단하게 됩니다.</p><p id="994bb3da-4722-4f39-983e-9112f53ec6e2" class="">&quot;Authorization&quot; 헤더는 이런 인증 토큰을 포함시키기 위한 헤더입니다. 일반적으로 &quot;Bearer {토큰}&quot;과 같은 형태의 값을 가지게 됩니다. 이 값을 axios의 기본 헤더에 추가해두면, axios를 통해 서버에 보내는 모든 요청에 이 헤더가 자동으로 포함되게 됩니다. 이렇게 하면 로그인한 사용자의 모든 요청이 인증된 요청으로 처리될 수 있습니다.</p><p id="029fc909-e79a-4f04-9aaf-941ba372d82c" class="">따라서 axios 기본 헤더에 &quot;Authorization&quot;을 추가하는 것은, 로그인한 사용자가 서버에 보내는 요청이 인증된 요청임을 표시하기 위한 것입니다. 이를 통해 서버는 요청을 보낸 클라이언트가 누구인지를 식별하고, 그에 맞는 응답을 보낼 수 있게 됩니다.</p><p id="a9494383-5fde-4135-9736-a016b0c16ba4" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">JWT 토큰 저장을 어디에다가 보관하는게 가장 보안이 강할까?</summary><div class="indented"><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">공격 종류에 대해서 궁금하다면..</summary><div class="indented"><ol type="1" id="40c9d058-3462-4543-a019-91ab8975aaa7" class="numbered-list" start="1"><li>XSS 공격<p id="504e9f27-cb66-4227-a4cf-d7d6dbb3f126" class="">공격자(해커)가 클라이언트 브라우저에 Javascript를 삽입해 실행하는 공격이다. 공격자가 <code>&lt;input&gt;</code>을 통해 Javascript를 서버로 전송해 서버에서 스크립트를 실행하거나, url에 Javascript를 적어 클라이언트에서 스크립트 실행이 가능하다면 공격자가 사이트에 스크립트를 삽입해 XSS 공격을 할 수 있다. 이때 공격자는 Javascript를 통해 사이트의 글로벌 변숫값을 가져오거나 그 값을 이용해 사이트인 척 API 콜을 요청할 수도 있다. 다시 말하면 공격자의 코드가 내 사이트의 로직인 척 행동할 수 있다는 거다.</p></li></ol><ol type="1" id="2373539f-fbe2-42fa-87ad-f7657e932813" class="numbered-list" start="2"><li>CSRF 공격<p id="6c8d66ea-bf65-44d3-b00b-fd5a502b1224" class="">공격자가 다른 사이트에서 우리 사이트의 API 콜을 요청해 실행하는 공격이다. API 콜을 요청할 수 있는 클라이언트 도메인이 누구인지 서버에서 통제하고 있지 않다면 CSRF가 가능한데, 이때 공격자가 클라이언트에 저장된 유저 인증정보를 서버에 보낼 수 있다면, 제대로 로그인한 것처럼 유저의 정보를 변경하거나 유저만 가능한 액션들을 수행할 수 있다. 예를 들어 CSRF에 취약한 은행 사이트가 있다면 로그인한 척 계좌 비밀번호를 바꾸거나 송금을 보낼 수 있는 것이다.</p></li></ol></div></details><p id="4d47b89a-33f3-4fb9-a273-4c7bcd5e31f8" class="">
</p><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="fd032779-2495-4c74-b60a-7bff23d9eab9"><div style="font-size:1.5em"><img class="icon" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png"/></div><div style="width:100%"><strong>결론 : 정답은 없다.</strong><br/>(JWT 토큰 저장 위치에 관한 &quot;가장&quot; 보안적인 방법을 지정하는 것은 어렵습니다. 왜냐하면 선택하는 저장 위치마다 장단점이 있고, 그로 인한 보안 위험도 다르기 때문입니다.)<br/></div></figure><h3 id="460a1fb2-39d0-4dd2-9560-883846a2c211" class="">1. localStorage에 저장</h3><h3 id="5f32f0dd-1894-4e85-985a-e695afa84f45" class="">👍 장점</h3><p id="57613a21-1f0b-461f-a4dd-464c2d0ed0fa" class=""><strong>CSRF 공격에는 안전하다.</strong></p><p id="010f31a8-43d4-41c6-80b1-28105374b989" class="">그 이유는 자동으로 request에 담기는 쿠키와는 다르게</p><p id="0dc8e1d1-8ab7-4f94-a6f3-a7635c8b1177" class="">js 코드에 의해 헤더에 담기므로 XSS를 뚫지 않는 이상</p><p id="d2fc0527-7131-4360-958d-6b5785151cf6" class="">공격자가 정상적인 사용자인 척 request를 보내기가 어렵다.</p><h3 id="5d03e66e-fef7-4df9-8ad5-e35435656a7e" class="">👎 단점</h3><p id="8d6496c1-7a15-4568-8801-fa6f12755356" class=""><strong>XSS에 취약하다.</strong></p><p id="7f530d81-7015-42aa-bbf5-eac0c12f6c04" class="">공격자가 localStorage에 접근하는 Js 코드 한 줄만 주입하면</p><p id="8f23dddb-13f1-4640-a243-efbe278baf92" class="">localStorage를 공격자가 내 집처럼 드나들 수 있다.</p><h3 id="96ca1b15-19d6-4ffb-be3a-17eee3e5cdf6" class="">2. cookie에 저장</h3><h3 id="a54fd0a4-efd4-43d3-aa5b-9535d7d8b137" class="">👍 장점</h3><p id="02cefd6c-1f0f-4524-b743-509f58d9e101" class=""><strong>XSS 공격으로부터 localStorage에 비해 안전하다.</strong></p><p id="ea3a109e-493f-4488-92a5-bd14bcaac794" class="">쿠키의 httpOnly 옵션을 사용하면 Js에서 쿠키에 접근 자체가 불가능하다.</p><p id="46500e5e-1928-4254-8afd-62cabba9a643" class="">그래서 XSS 공격으로 쿠키 정보를 탈취할 수 없다.</p><p id="a6ad8248-cb46-45e3-aa74-fcb2df32fcf2" class="">(httpOnly 옵션은 서버에서 설정할 수 있음)</p><p id="18635810-0396-4178-b47b-29cd44e4ac49" class="">하지만 <strong>XSS 공격으로부터 완전히 안전한 것은 아니다.</strong></p><p id="970c9ed0-320e-41fb-bb5c-43c1a64a51a1" class="">httpOnly 옵션으로 쿠키의 내용을 볼 수 없다 해도</p><p id="a4eff0dd-a605-4b4a-8208-673716046360" class="">js로 request를 보낼 수 있으므로 자동으로 request에 실리는 쿠키의 특성 상</p><p id="9e4bad82-f4d4-4cc0-9e75-6ea0da99e92f" class="">사용자의 컴퓨터에서 요청을 위조할 수 있기 때문.</p><p id="e5547254-dfa6-45b6-a40c-f58a12908414" class="">공격자가 귀찮을 뿐이지 XSS가 뚫린다면 httpOnly cookie도 안전하진 않다.</p><p id="78ded369-c7e9-4d15-b7d3-c076160a0238" class="">참고 : <a href="https://dev.to/cotter/localstorage-vs-cookies-all-you-need-to-know-about-storing-jwt-tokens-securely-in-the-front-end-15id">&#x27;About XSS Attack&#x27; 부분 참고</a></p><h3 id="b08ea1f3-ae76-48ff-9dcb-0fc193a24d74" class="">👎 단점</h3><p id="2abe58a9-76f0-4a59-afdd-165b99a2e711" class=""><strong>CSRF 공격에 취약하다.</strong></p><p id="d8ddac72-5336-460c-a538-a0e60146c1fd" class="">자동으로 http request에 담아서 보내기 때문에</p><p id="08fc03a2-d92c-4898-a85b-a8fada30aa57" class="">공격자가 request url만 안다면</p><p id="cff6291c-957f-454a-9102-a84804406115" class="">사용자가 관련 link를 클릭하도록 유도하여 request를 위조하기 쉽다.</p><p id="96fccaa9-3784-482f-9c00-67376fc9a7a3" class="">
</p><h2 id="5ae34e59-4d73-439c-a8b3-b10b80e4af99" class="">해결</h2><p id="820395a7-ecb8-44fc-94d1-f3be667490dc" class="">현재 프로젝트에서는 </p><p id="08dd334f-6a5d-486e-99f3-bdf146a4c0f8" class="">쿠키에 저장하는 방식을 채택했고, 브라우저-localStoreage에 탐색을 못하게끔,</p><p id="9f2fc57d-f593-4bc8-9375-3aba1bd6875a" class="">httponly옵션을 넣었다.</p><p id="88f7989a-c295-4018-b868-499a83678757" class="">쿠키방식은 CSRF방식에 취약하니, 배포단계에 CSRF 설정을 허용하도록 하겠다.</p><p id="d60abf29-366c-4aa6-a15b-3f910802dee0" class="">
</p><p id="6aab078e-3f09-43ce-802a-5d624d73043e" class="">
</p><p id="3a9a2ee3-7692-4f9d-a63c-238276f9f1cb" class="">
</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0"><strong>Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token);</strong></summary><div class="indented"><h3 id="1630f5d5-9b71-47d1-9c51-066e97d98399" class="">문제</h3><p id="729ce279-63fd-40f8-8ab3-fe8bac948513" class="">어려운 용어가 있어서 코드 분석을 해보았다.</p><p id="75088896-6ee8-4c30-9c5c-b6fb8d20cdc2" class="">
</p><h3 id="6b88407b-fa8f-4569-9616-8fda0138d5a0" class="">해결</h3><figure class="block-color-gray_background callout" style="white-space:pre-wrap;display:flex" id="70528d3a-6c3d-468a-aa4c-b5af66bf945b"><div style="font-size:1.5em"><img class="icon" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png"/></div><div style="width:100%"><strong>&#x27;파싱&#x27;이란 어떤 데이터를 분석하고 이해하는 과정을 말합니다. <br/>주어진 데이터를 구조에 따라 분해하고, 그 의미를 해석하는 것이죠.<br/></strong></div></figure><p id="43e67d4b-cf2f-41b4-9e0c-9f5387500eea" class=""><code>Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token);</code></p><p id="e5297e67-37c3-4f2e-92fd-cd37bf9f3acd" class=""><code>Jwts.parserBuilder()</code>: <mark class="highlight-blue">JWT를 파싱하기 위한 빌더</mark>를 생성합니다.<mark class="highlight-red"><strong> 빌더 패턴은 복잡한 객체를 생성할 때 사용하는 디자인 패턴</strong></mark>으로, 빌더를 통해 원하는 설정을 하고 나서 객체를 생성합니다.</p><p id="662f6160-2b63-49da-9fe3-735637a5bd6b" class="">
</p><p id="3a32c9f5-bc1b-4176-8d08-3a947d127584" class=""><code>setSigningKey(JWT_SECRET_KEY)</code>: 파싱할 때 사용할 서명 키를 설정합니다. JWT는 서명 키를 사용하여 토큰이 변조되지 않았음을 검증합니다. 따라서 토큰을 생성할 때 사용한 서명 키와 동일한 키를 사용해야 합니다.</p><p id="6ead9d1c-5a18-43a6-be16-ae24f7321558" class="">
</p><p id="30ebe111-3b1b-466e-81c1-afddc5bf6df5" class=""><code>build()</code>: 설정이 완료되면 빌더를 통해 JWT 파서를 생성합니다.</p><p id="52a0867f-67d7-431e-a498-afbc33e377e0" class=""><code>parseClaimsJws(token)</code>: 생성한 파서를 사용하여 주어진 JWT를 파싱합니다. 파싱 결과로 <code>Jws&lt;Claims&gt;</code> 객체가 반환되는데, 이 객체를 통해 토큰의 헤더, 페이로드, 서명을 얻을 수 있습니다.</p><p id="a70040d4-9cb8-450b-a4e1-1326382e907a" class="">따라서 이 코드는 주어진 JWT를 서명 키 <code>JWT_SECRET_KEY</code>로 검증하고 파싱하는 작업을 수행합니다. 이후 반환된 <code>Jws&lt;Claims&gt;</code> 객체를 통해 토큰의 정보를 사용할 수 있습니다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">JWT 토큰 유효성 검사로직을 상시 실행하는데, 비로그인 사용자에게도 오류창을<br/>띄워서 불편하게 하는 문제를 해결해보자<br/></summary><div class="indented"><h3 id="2a20a185-4d80-4147-9203-682ee1c7deea" class="">App.js</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="4e441d0e-335f-4def-9e37-cc5eec6d729b" class="code"><code class="language-Java">const { isLoging } = useSelector(state =&gt; state.auth);

  const dispatch = useDispatch();
  useEffect(()=&gt;{
    if(isLoging) return;
    try {
      dispatch(isLoggedIn());
    } catch (error) {
      console.log(&#x27;현재 로그인 상태가 아닙니다.&#x27;);
    }
  },[dispatch,isLoging]);</code></pre><h3 id="6e32c9e5-9c55-4d80-af24-c062d1604be0" class="">[백엔드] UserController.java</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="6e22c005-1033-438b-a7e7-3f9a7a9318b5" class="code"><code class="language-Java">@PostMapping(&quot;/validateToken&quot;)
	public ResponseEntity&lt;?&gt; validateToken(
			HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error(&quot;Cookie is empty&quot;)
					.build();
			return ResponseEntity.status(404).body(responseDTO);
		}
	    String token = null;
	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals(&quot;token&quot;)) {
	            token = cookie.getValue();
	            break;
	        }
	    }
		
	    if (token == null) {
	        ResponseDTO responseDTO = ResponseDTO.builder()
	                .error(&quot;Token is empty&quot;)
	                .build();
	        return ResponseEntity.status(404).body(responseDTO);
	    }
	    //토큰을 찾았을떄 검사시작
	    try {
			Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token);
		} catch (JwtException e) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error(&quot;Token is invalid&quot;)
					.build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	    
	    
		return ResponseEntity.ok().body(&quot;validate success&quot;);
	}</code></pre><p id="44f27f43-777f-4f42-ab40-db74f27ef55a" class="">
</p><h3 id="380024d5-4f1b-421f-8822-d25a3f7423b6" class="">문제</h3><p id="72caa5dc-2165-4271-82ab-b6804addea0b" class="">로그인한 사용자 (인증된 사용자)만 접속가능하게 하려는 조건부 라우팅을 구현하려했다.</p><p id="64eec513-4e63-47f0-bd21-7cbc14c74af6" class="">인증 여부를 백엔드에서 API를 만들어 호출한 후,</p><p id="b4c438fa-9f6d-4c32-b1b2-ea4ee32afb87" class="">App.js에서 호출 하고, 그에 대한 유무를 state로 받아서 해당 state 값에 따라<br/>조건부 라우터기능을 구현하려는데,<br/><br/><strong>로그인된 사용자임에도 불구하고, url 이동이 안됨.</strong></p><p id="f95229a5-b813-46a6-9e25-5e800123d277" class=""><strong>비로그인 사용자에게 앱 시작 첫 화면부터 오류 팝업창 출력</strong></p><p id="42b1e839-078a-470b-9f51-44fd99325fe9" class="">이러한 문제들이 생겼다.</p><p id="81564ea3-d2d9-492b-8ff3-0a90f37b98f7" class="">
</p><h3 id="faa2043b-8def-4d45-a40f-938e752e3277" class="">해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="1f0c60bb-1f8f-4e1b-9930-f847a2926bfb" class="code"><code class="language-JavaScript">export const login = (username, password) =&gt; async dispatch =&gt; {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const response = await authAPI.loginApi(username, password);
    dispatch({ type: LOGIN_SUCCESS, payload: response.data });
    sessionStorage.setItem(&#x27;isLoging&#x27;, true);
    return response.data;
  } catch (e) {
    dispatch({ type: LOGIN_FAILURE, error: e });
    throw e;
  }
};</code></pre><p id="59059fa8-9aa1-4618-80e3-d9c2bd27ecee" class="">스프링에서 중간에 DTO를 만들어서 해결하는것에서 아이디어를 따와서</p><p id="4327d02f-c327-4e34-ae72-6ae1e1608078" class="">로그인에 대한 유무만 세션에 저장시켜서</p><p id="399c195b-f582-4295-86d4-07e67658411b" class="">안전도 챙기고, 전역적인 설정(로그인 유지)도 챙겼다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">토큰이 유효한지 검증하는 api를 호출했으나, 비로그인 사용자에게도 오류를 호출하는건에 대하여</summary><div class="indented"><h3 id="49a5ecf3-4da1-4655-8d5a-106f72192565" class="">문제</h3><p id="1dab470e-5e2b-4002-b01b-b16c334fab19" class="">현재 로그인된 사용자의 토큰이 유요한지 검증하는 API 및 액션함수를 디스패치 하는데,</p><p id="8f272524-b49c-4fcd-af93-91b184e330e8" class="">문제는 비로그인 된 사용자는 토큰이 없는데도 불구하고, 해당 사용자에게 까지</p><p id="c795ecd1-7f0d-4cee-9e8c-8b9ba8582e5b" class="">오류를 호출시켜서 불편함을 겪었다.</p><p id="745ebd6f-8af7-46d3-8680-4e1d909b327a" class="">
</p><h3 id="af2b9045-b853-4a9c-99e9-ddc26df21e78" class="">해결</h3><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="e03027c4-aa2d-403f-8e15-6f47e207cfe8" class="code"><code class="language-JavaScript">export const isLoggedIn = () =&gt; async dispatch =&gt; {
  dispatch({ type : IS_LOGGED_IN });
  try {
    const response = await authAPI.validateTokenApi();
    dispatch({ type : IS_LOGGED_IN_SUCCESS, payload: response.data});
    console.log(&#x27;validate success&#x27;);
    return response.data;
  } catch (e) {
    if (e.response &amp;&amp; e.response.status === 401) {//비로그인 사용자 예외처리
      dispatch({ type: LOGOUT });
      console.log(&#x27;비로그인 사용자임(토큰없음)&#x27;);
    } else {
      dispatch({ type : IS_LOGGED_IN_FAILURE, error: e});
      throw e;
    }
  }
}</code></pre><p id="279c1f85-e900-48a6-81cd-9692234f0463" class="">아예 남아있는 쓰래기값 데이터들을 LOGOUT 액션함수를 디스패치를 통해 없앴고,</p><p id="40685550-b572-4b95-9d75-a7f1efdf7d9e" class="">진짜 인증되지 않은 사용자에게만 error를 던지도록</p><p id="6d7680bc-cee1-4625-833e-c5a1a120c5ba" class="">if-else문을 사용했다.</p></div></details><details open=""><summary style="font-weight:600;font-size:1.25em;line-height:1.3;margin:0">JWT토큰을 쿠키 저장방식을 사용해도 크롬 탭을 닫아도 자동 로그아웃이 되는가<br/>&amp;<br/>크롬탭을 닫고 다시 열었을떄 왜 USER정보만 안나오는가<br/></summary><div class="indented"><h3 id="dc7d0f4d-f7b2-4c42-8d49-78ccd69872b0" class="">해결</h3><p id="e23b4aa7-6203-4322-a707-93a50d958567" class=""><code>import storage from &#x27;redux-persist/lib/storage’</code><br/>STOREAGE 즉 store 상태값을을 localStoraage로 변경했다.<br/></p><p id="42c4f5f8-d55d-49a3-aeee-a2d8b35eac35" class="">
</p></div></details><p id="eb0b6555-7d48-455c-bab1-42534a4f7fcb" class="">
</p></div></article><span class="sans" style="font-size:14px;padding-top:2em"></span></body></html>