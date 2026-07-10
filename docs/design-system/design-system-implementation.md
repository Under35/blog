# 设计系统实现指南

## 快速开始

### 1. 在项目中集成设计系统

#### Option A: CSS 变量文件

创建 `styles/design-system.css`：

```css
:root {
  /* ========================================
     颜色系统
     ======================================== */
  
  /* Primary Blue */
  --color-primary-50:  #E3F2FD;
  --color-primary-100: #BBDEFB;
  --color-primary-200: #90CAF9;
  --color-primary-300: #64B5F6;
  --color-primary-400: #42A5F5;
  --color-primary-500: #2196F3;  /* 主色 */
  --color-primary-600: #1E88E5;
  --color-primary-700: #1976D2;
  --color-primary-800: #1565C0;
  --color-primary-900: #0D47A1;
  
  /* Neutral Gray */
  --color-neutral-0:   #FFFFFF;
  --color-neutral-50:  #FAFAFA;
  --color-neutral-100: #F5F5F5;
  --color-neutral-200: #EEEEEE;
  --color-neutral-300: #E0E0E0;
  --color-neutral-400: #BDBDBD;
  --color-neutral-500: #9E9E9E;
  --color-neutral-600: #757575;
  --color-neutral-700: #616161;  /* 主文本 */
  --color-neutral-800: #424242;
  --color-neutral-900: #212121;  /* 标题 */
  
  /* Functional Colors */
  --color-success-light:   #C8E6C9;
  --color-success-main:    #4CAF50;
  --color-success-dark:    #388E3C;
  
  --color-warning-light:   #FFE0B2;
  --color-warning-main:    #FF9800;
  --color-warning-dark:    #F57C00;
  
  --color-error-light:     #FFCDD2;
  --color-error-main:      #F44336;
  --color-error-dark:      #D32F2F;
  
  --color-info-light:      #B3E5FC;
  --color-info-main:       #00BCD4;
  --color-info-dark:       #0097A7;
  
  /* ========================================
     排版系统
     ======================================== */
  
  /* Font Families */
  --font-family-sans: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', 'Noto Sans SC', sans-serif;
  --font-family-mono: 'Monaco', 'Courier New', 'Courier', monospace;
  
  /* Font Sizes */
  --font-size-title-xl:  32px;
  --font-size-title-l:   28px;
  --font-size-title-m:   24px;
  --font-size-title-s:   20px;
  --font-size-heading-1: 18px;
  --font-size-heading-2: 16px;
  --font-size-body:      14px;
  --font-size-small:     12px;
  --font-size-xsmall:    11px;
  
  /* Font Weights */
  --font-weight-light:   300;
  --font-weight-regular: 400;
  --font-weight-medium:  500;
  --font-weight-semibold: 600;
  --font-weight-bold:    700;
  
  /* Line Heights */
  --line-height-tight:   1.2;
  --line-height-normal:  1.5;
  --line-height-relaxed: 1.8;
  
  /* ========================================
     间距系统
     ======================================== */
  
  --spacing-xs:  4px;
  --spacing-s:   8px;
  --spacing-m:   16px;
  --spacing-l:   24px;
  --spacing-xl:  32px;
  --spacing-2xl: 48px;
  --spacing-3xl: 64px;
  
  /* ========================================
     圆角系统
     ======================================== */
  
  --border-radius-sm: 4px;
  --border-radius-md: 6px;
  --border-radius-lg: 8px;
  --border-radius-xl: 12px;
  --border-radius-full: 9999px;
  
  /* ========================================
     阴影系统
     ======================================== */
  
  --shadow-xs:    0 1px 2px rgba(0, 0, 0, 0.05);
  --shadow-sm:    0 1px 3px rgba(0, 0, 0, 0.08);
  --shadow-md:    0 2px 8px rgba(0, 0, 0, 0.1);
  --shadow-lg:    0 8px 24px rgba(0, 0, 0, 0.12);
  --shadow-xl:    0 16px 40px rgba(0, 0, 0, 0.15);
  
  /* ========================================
     过渡和动画
     ======================================== */
  
  --transition-fast:   150ms ease;
  --transition-normal: 200ms ease;
  --transition-slow:   300ms ease;
  
  /* ========================================
     响应式断点
     ======================================== */
  
  --breakpoint-xs: 320px;
  --breakpoint-sm: 640px;
  --breakpoint-md: 1024px;
  --breakpoint-lg: 1440px;
  --breakpoint-xl: 1920px;
}

/* ========================================
   深色模式覆盖
   ======================================== */

@media (prefers-color-scheme: dark) {
  :root {
    /* 背景 */
    --color-bg-primary:   #121212;
    --color-bg-secondary: #1E1E1E;
    --color-bg-tertiary:  #2A2A2A;
    
    /* 文本 */
    --color-text-primary:   #FFFFFF;
    --color-text-secondary: #B3B3B3;
    --color-text-tertiary:  #808080;
    
    /* 边框 */
    --color-border: rgba(255, 255, 255, 0.1);
  }
}

/* ========================================
   浅色模式显式定义
   ======================================== */

@media (prefers-color-scheme: light) {
  :root {
    --color-bg-primary:   #FFFFFF;
    --color-bg-secondary: #FAFAFA;
    --color-bg-tertiary:  #F5F5F5;
    
    --color-text-primary:   #212121;
    --color-text-secondary: #616161;
    --color-text-tertiary:  #9E9E9E;
    
    --color-border: rgba(0, 0, 0, 0.08);
  }
}
```

#### Option B: SCSS 变量文件

创建 `styles/_variables.scss`：

```scss
// ========================================
// 颜色系统
// ========================================

$color-primary: (
  50:  #E3F2FD,
  100: #BBDEFB,
  200: #90CAF9,
  300: #64B5F6,
  400: #42A5F5,
  500: #2196F3,  // 主色
  600: #1E88E5,
  700: #1976D2,
  800: #1565C0,
  900: #0D47A1,
);

$color-neutral: (
  0:   #FFFFFF,
  50:  #FAFAFA,
  100: #F5F5F5,
  200: #EEEEEE,
  300: #E0E0E0,
  400: #BDBDBD,
  500: #9E9E9E,
  600: #757575,
  700: #616161,  // 主文本
  800: #424242,
  900: #212121,  // 标题
);

$color-success: (
  light: #C8E6C9,
  main:  #4CAF50,
  dark:  #388E3C,
);

// ========================================
// 排版系统
// ========================================

$font-family-sans: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', 'Noto Sans SC', sans-serif;
$font-family-mono: 'Monaco', 'Courier New', 'Courier', monospace;

$font-sizes: (
  title-xl:  32px,
  title-l:   28px,
  title-m:   24px,
  heading-1: 18px,
  body:      14px,
  small:     12px,
);

$font-weights: (
  light:     300,
  regular:   400,
  medium:    500,
  semibold:  600,
  bold:      700,
);

// ========================================
// 间距系统
// ========================================

$spacing: (
  xs:  4px,
  s:   8px,
  m:   16px,
  l:   24px,
  xl:  32px,
  2xl: 48px,
  3xl: 64px,
);

// ========================================
// 阴影系统
// ========================================

$shadow: (
  sm: 0 1px 3px rgba(0, 0, 0, 0.08),
  md: 0 2px 8px rgba(0, 0, 0, 0.1),
  lg: 0 8px 24px rgba(0, 0, 0, 0.12),
  xl: 0 16px 40px rgba(0, 0, 0, 0.15),
);

// 快速访问函数
@function color($palette, $shade: 500) {
  @return map-get(map-get($color, $palette), $shade);
}

@function spacing($size) {
  @return map-get($spacing, $size);
}

@function shadow($size) {
  @return map-get($shadow, $size);
}
```

### 2. HTML 导入

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My App</title>
    
    <!-- 导入设计系统 -->
    <link rel="stylesheet" href="/styles/design-system.css">
    <link rel="stylesheet" href="/styles/components.css">
    
    <!-- 或者在 CSS 中导入 -->
    <!-- @import url('design-system.css'); -->
</head>
<body>
    <!-- 应用内容 -->
</body>
</html>
```

---

## 常用组件实现

### 按钮组件

```html
<button class="btn btn-primary">主按钮</button>
<button class="btn btn-secondary">副按钮</button>
<button class="btn btn-ghost">幽灵按钮</button>
```

```css
.btn {
  padding: var(--spacing-s) var(--spacing-m);
  border: none;
  border-radius: var(--border-radius-md);
  font-size: var(--font-size-body);
  font-weight: var(--font-weight-medium);
  cursor: pointer;
  transition: all var(--transition-normal);
  font-family: inherit;
}

.btn-primary {
  background-color: var(--color-primary-500);
  color: var(--color-neutral-0);
}

.btn-primary:hover {
  background-color: var(--color-primary-700);
  box-shadow: var(--shadow-md);
}

.btn-primary:focus {
  outline: 2px solid var(--color-primary-500);
  outline-offset: 2px;
}

.btn-secondary {
  background-color: transparent;
  color: var(--color-primary-500);
  border: 1px solid var(--color-primary-500);
}

.btn-secondary:hover {
  background-color: var(--color-primary-50);
}
```

### 输入框组件

```html
<label class="form-group">
  <span class="label">邮箱地址 *</span>
  <input type="email" class="input" placeholder="your@email.com" required>
  <small class="help-text">我们不会分享你的邮箱地址</small>
</label>
```

```css
.form-group {
  margin-bottom: var(--spacing-l);
}

.label {
  display: block;
  font-size: var(--font-size-small);
  font-weight: var(--font-weight-medium);
  color: var(--color-neutral-700);
  margin-bottom: var(--spacing-xs);
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.label.required::after {
  content: '*';
  color: var(--color-error-main);
  margin-left: 2px;
}

.input {
  width: 100%;
  padding: var(--spacing-s) var(--spacing-m);
  border: 1px solid var(--color-neutral-300);
  border-radius: var(--border-radius-md);
  font-size: var(--font-size-body);
  font-family: inherit;
  transition: all var(--transition-fast);
}

.input:focus {
  outline: none;
  border-color: var(--color-primary-500);
  box-shadow: 0 0 0 3px rgba(33, 150, 243, 0.1);
}

.help-text {
  display: block;
  font-size: var(--font-size-small);
  color: var(--color-neutral-600);
  margin-top: var(--spacing-xs);
}
```

### 卡片组件

```html
<div class="card">
  <div class="card__header">
    <h3 class="card__title">卡片标题</h3>
  </div>
  <div class="card__content">
    这是卡片内容
  </div>
  <div class="card__footer">
    <button class="btn btn-secondary">取消</button>
    <button class="btn btn-primary">确认</button>
  </div>
</div>
```

```css
.card {
  background-color: var(--color-bg-primary);
  border-radius: var(--border-radius-lg);
  box-shadow: var(--shadow-md);
  overflow: hidden;
  transition: all var(--transition-normal);
}

.card:hover {
  box-shadow: var(--shadow-lg);
  transform: translateY(-2px);
}

.card__header {
  padding: var(--spacing-l);
  border-bottom: 1px solid var(--color-border);
}

.card__title {
  font-size: var(--font-size-heading-1);
  font-weight: var(--font-weight-semibold);
  margin: 0;
  color: var(--color-text-primary);
}

.card__content {
  padding: var(--spacing-l);
  font-size: var(--font-size-body);
  color: var(--color-text-secondary);
  line-height: var(--line-height-normal);
}

.card__footer {
  padding: var(--spacing-m) var(--spacing-l);
  border-top: 1px solid var(--color-border);
  display: flex;
  justify-content: flex-end;
  gap: var(--spacing-m);
}
```

### 网格布局

```html
<div class="container">
  <div class="grid">
    <div class="grid__item grid__item--full">Full Width</div>
    <div class="grid__item grid__item--half">Half</div>
    <div class="grid__item grid__item--half">Half</div>
    <div class="grid__item grid__item--third">Third</div>
    <div class="grid__item grid__item--third">Third</div>
    <div class="grid__item grid__item--third">Third</div>
  </div>
</div>
```

```css
.container {
  max-width: 1440px;
  margin: 0 auto;
  padding: 0 var(--spacing-l);
}

.grid {
  display: grid;
  grid-template-columns: repeat(12, 1fr);
  gap: var(--spacing-m);
}

.grid__item {
  grid-column: span 12;
}

.grid__item--full  { grid-column: span 12; }
.grid__item--half  { grid-column: span 6; }
.grid__item--third { grid-column: span 4; }

/* 响应式 */
@media (max-width: 1024px) {
  .grid__item--half { grid-column: span 12; }
}

@media (max-width: 640px) {
  .grid {
    grid-template-columns: repeat(4, 1fr);
    gap: var(--spacing-m);
  }
  
  .grid__item--half { grid-column: span 4; }
  .grid__item--third { grid-column: span 4; }
}
```

---

## 深色模式实现

### 自动适配深色模式

```css
/* 使用 CSS 变量自动适配 */
.card {
  background-color: var(--color-bg-primary);
  color: var(--color-text-primary);
  border: 1px solid var(--color-border);
}

/* 会根据系统偏好自动切换 */
@media (prefers-color-scheme: dark) {
  /* CSS 变量在 :root 中已定义 */
}
```

### 手动切换深色模式

```html
<button id="theme-toggle">🌙 深色模式</button>

<script>
  const themeToggle = document.getElementById('theme-toggle');
  
  themeToggle.addEventListener('click', () => {
    const html = document.documentElement;
    const isDark = html.getAttribute('data-theme') === 'dark';
    
    html.setAttribute('data-theme', isDark ? 'light' : 'dark');
    localStorage.setItem('theme', isDark ? 'light' : 'dark');
    
    themeToggle.textContent = isDark ? '🌙 深色模式' : '☀️ 浅色模式';
  });
  
  // 应用保存的主题
  const savedTheme = localStorage.getItem('theme');
  if (savedTheme) {
    document.documentElement.setAttribute('data-theme', savedTheme);
  }
</script>
```

```css
/* 使用 data-theme 属性切换 */
:root[data-theme="dark"] {
  --color-bg-primary: #121212;
  --color-text-primary: #FFFFFF;
  /* ... 其他变量 */
}

:root[data-theme="light"] {
  --color-bg-primary: #FFFFFF;
  --color-text-primary: #212121;
  /* ... 其他变量 */
}
```

---

## 响应式设计实现

### 移动优先方法

```css
/* 默认：移动设备样式 */
.header {
  padding: var(--spacing-m);
  font-size: var(--font-size-body);
}

/* 平板及以上 */
@media (min-width: 640px) {
  .header {
    padding: var(--spacing-l);
    font-size: var(--font-size-heading-2);
  }
}

/* 桌面 */
@media (min-width: 1024px) {
  .header {
    padding: var(--spacing-2xl);
    font-size: var(--font-size-heading-1);
  }
}
```

### 流体排版

```css
/* 根据视口宽度缩放字体 */
.title {
  font-size: clamp(
    20px,       /* 最小值 */
    5vw,        /* 理想值 */
    48px        /* 最大值 */
  );
}
```

---

## 可访问性检查清单

- [ ] 所有文本对比度满足 WCAG AA（4.5:1）
- [ ] 所有交互元素都有焦点状态
- [ ] 支持键盘导航（Tab）
- [ ] 使用语义化 HTML
- [ ] 提供 ARIA 标签
- [ ] 图片有替代文本
- [ ] 颜色不是唯一的信息传达方式
- [ ] 触摸目标至少 44×44px
- [ ] 移动设备完整测试
- [ ] 屏幕阅读器测试

---

## 常见问题 (FAQ)

### Q: 如何自定义主色？

A: 修改 CSS 变量：
```css
:root {
  --color-primary-500: #YOUR_COLOR;
  --color-primary-700: #DARKER_SHADE;
}
```

### Q: 如何添加新的间距值？

A: 在 `design-system.css` 中添加：
```css
--spacing-custom: 20px;
```

### Q: 如何处理不支持 CSS 变量的浏览器？

A: 使用 fallback：
```css
.btn {
  background-color: #2196F3;  /* fallback */
  background-color: var(--color-primary-500);
}
```

### Q: 如何在 JavaScript 中访问 CSS 变量？

A: 
```javascript
// 读取
const primaryColor = getComputedStyle(document.documentElement)
  .getPropertyValue('--color-primary-500');

// 设置
document.documentElement.style.setProperty('--color-primary-500', '#FF0000');
```

---

## 工具推荐

- **颜色检查**: WebAIM Contrast Checker, WAVE
- **设计工具**: Figma（支持变量和设计令牌导出）
- **CSS-in-JS**: CSS Modules, Tailwind CSS, styled-components
- **自动化工具**: Storybook (组件文档), Chromatic (视觉测试)

---

## 版本历史

| 版本 | 日期 | 更新内容 |
|------|------|---------|
| 1.0.0 | 2026-07-10 | 初始版本，完整的设计系统实现指南 |

---

**维护者**: Design System Team  
**最后更新**: 2026-07-10
