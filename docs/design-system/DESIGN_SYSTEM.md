# 🎨 前端设计系统规范

**版本**: 1.0.0  
**最后更新**: 2026-07-10  
**维护者**: Under35 Design Team

---

## 目录
1. [品牌价值观](#品牌价值观)
2. [色彩系统](#色彩系统)
3. [排版系统](#排版系统)
4. [间距与布局](#间距与布局)
5. [组件库](#组件库)
6. [可访问性](#可访问性)
7. [交互规范](#交互规范)
8. [响应式设计](#响应式设计)
9. [深色模式](#深色模式)
10. [代码示例](#代码示例)

---

## 品牌价值观

### 设计原则

我们的设计遵循以下核心原则：

1. **清晰 (Clarity)** - 信息架构清晰，用户意图明确
2. **高效 (Efficiency)** - 减少用户操作步骤，提升工作效率
3. **一致 (Consistency)** - 整体风格统一，可预测的用户体验
4. **可访问 (Accessible)** - 确保所有用户都能使用，无障碍设计
5. **优雅 (Elegance)** - 简洁美观，不过度装饰

### 设计目标

- ✅ 现代、专业、友好的视觉语言
- ✅ 数据驱动型应用的可视化呈现
- ✅ 高可用性和响应式适配
- ✅ 深浅主题一致体验
- ✅ 快速原型和组件复用

---

## 色彩系统

### 主色板 (Primary Palette)

#### 蓝色系（主品牌色）
```
Primary Blue:
  50:  #E3F2FD
  100: #BBDEFB
  200: #90CAF9
  300: #64B5F6
  400: #42A5F5
  500: #2196F3  ← 主色
  600: #1E88E5
  700: #1976D2
  800: #1565C0
  900: #0D47A1

CSS Variables:
--color-primary-50:  #E3F2FD
--color-primary-500: #2196F3
--color-primary-900: #0D47A1
```

#### 中立灰色（文本和背景）
```
Neutral:
  0:   #FFFFFF
  50:  #FAFAFA
  100: #F5F5F5
  200: #EEEEEE
  300: #E0E0E0
  400: #BDBDBD
  500: #9E9E9E  ← 次要文本
  600: #757575
  700: #616161  ← 主要文本
  800: #424242
  900: #212121

CSS Variables:
--color-neutral-white:  #FFFFFF
--color-neutral-50:     #FAFAFA
--color-neutral-700:    #616161  (主文本)
--color-neutral-900:    #212121  (标题文本)
```

### 功能色 (Functional Colors)

```
成功 (Success):
  Light:   #C8E6C9
  Main:    #4CAF50
  Dark:    #388E3C

警告 (Warning):
  Light:   #FFE0B2
  Main:    #FF9800
  Dark:    #F57C00

错误 (Error):
  Light:   #FFCDD2
  Main:    #F44336
  Dark:    #D32F2F

信息 (Info):
  Light:   #B3E5FC
  Main:    #00BCD4
  Dark:    #0097A7
```

### 渐变色 (Gradients)

```
品牌渐变 (Brand Gradient):
  background: linear-gradient(135deg, #2196F3 0%, #1976D2 100%);

柔和渐变 (Soft Gradient):
  background: linear-gradient(135deg, #E3F2FD 0%, #F3E5F5 100%);

暗色渐变 (Dark Gradient):
  background: linear-gradient(135deg, #1565C0 0%, #0D47A1 100%);
```

### 使用场景

| 色彩 | 使用场景 | 对比度 |
|------|---------|--------|
| Primary 500 | 按钮、链接、选中状态 | 4.5:1 ✅ |
| Primary 700 | 悬停状态、活跃状态 | 7:1 ✅ |
| Neutral 700 | 正文、标签、说明文本 | 10.3:1 ✅ |
| Error 500 | 错误提示、验证失败 | 5.2:1 ✅ |
| Success 500 | 成功提示、通过验证 | 5.8:1 ✅ |

---

## 排版系统

### 字体族

```css
/* 英文字体 */
--font-family-sans: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;

/* 中文字体 */
--font-family-sans-cn: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', 'Noto Sans SC', 'Noto Sans', sans-serif;

/* 等宽字体 (代码) */
--font-family-mono: 'Monaco', 'Courier New', 'Courier', monospace;

/* 推荐使用 */
font-family: var(--font-family-sans-cn);
```

### 字体大小规范 (Type Scale)

采用 **1.125 (9/8)** 的递增比例：

```
Title XL:    32px / 2rem    (主页面标题)
Title L:     28px / 1.75rem (页面标题)
Title M:     24px / 1.5rem  (卡片标题)
Title S:     20px / 1.25rem (小标题)

Heading 1:   18px / 1.125rem  (大标题)
Heading 2:   16px / 1rem      (中标题)
Body:        14px / 0.875rem  (正文)
Small:       12px / 0.75rem   (辅助文本)
XSmall:      11px / 0.6875rem (提示文本)

CSS Variables:
--font-size-title-xl:  32px
--font-size-title-l:   28px
--font-size-title-m:   24px
--font-size-heading-1: 18px
--font-size-body:      14px
--font-size-small:     12px
```

### 行高与字重

```css
/* 行高 (Line Height) */
--line-height-tight:   1.2   (标题)
--line-height-normal:  1.5   (正文)
--line-height-relaxed: 1.8   (长文本)

/* 字重 (Font Weight) */
--font-weight-light:   300   (淡显)
--font-weight-regular: 400   (正常)
--font-weight-medium:  500   (中等)
--font-weight-semibold: 600  (半粗)
--font-weight-bold:    700   (加粗)

/* 推荐组合 */
标题:  font-weight: 600; line-height: 1.2;
正文:  font-weight: 400; line-height: 1.5;
输入框: font-weight: 400; line-height: 1.5;
```

### 排版样式预设

```css
/* Styles */
.title-xl {
  font-size: 32px;
  font-weight: 600;
  line-height: 1.2;
  letter-spacing: -0.5px;
}

.title-m {
  font-size: 24px;
  font-weight: 600;
  line-height: 1.3;
  letter-spacing: -0.3px;
}

.heading-1 {
  font-size: 18px;
  font-weight: 600;
  line-height: 1.4;
}

.body {
  font-size: 14px;
  font-weight: 400;
  line-height: 1.5;
}

.body-small {
  font-size: 12px;
  font-weight: 400;
  line-height: 1.6;
  color: var(--color-neutral-600);
}
```

---

## 间距与布局

### 间距缩放系统 (Spacing Scale)

采用 **8px 基础间距** 的 Fibonacci 递增：

```
XS:  4px   (0.5rem)  - 非常紧凑
S:   8px   (1rem)    - 紧凑间距
M:   16px  (2rem)    - 标准间距
L:   24px  (3rem)    - 宽松间距
XL:  32px  (4rem)    - 大间距
2XL: 48px  (6rem)    - 特大间距
3XL: 64px  (8rem)    - 超大间距

CSS Variables:
--spacing-xs:  4px
--spacing-s:   8px
--spacing-m:   16px
--spacing-l:   24px
--spacing-xl:  32px
--spacing-2xl: 48px
--spacing-3xl: 64px
```

### 应用规则

```css
/* 内部间距 (Padding) */
.button {
  padding: var(--spacing-s) var(--spacing-m);  /* 8px 16px */
}

.card {
  padding: var(--spacing-l);  /* 24px */
}

.page-section {
  padding: var(--spacing-2xl);  /* 48px */
}

/* 外部间距 (Margin) */
.heading {
  margin-bottom: var(--spacing-l);  /* 24px */
}

.paragraph {
  margin-bottom: var(--spacing-m);  /* 16px */
}

/* 元素间距 */
.item + .item {
  margin-top: var(--spacing-m);  /* 16px */
}
```

### 网格系统 (Grid System)

```css
/* 12列网格，间距 16px */
.container {
  display: grid;
  grid-template-columns: repeat(12, 1fr);
  gap: var(--spacing-m);  /* 16px */
  max-width: 1440px;
  margin: 0 auto;
  padding: 0 var(--spacing-l);
}

/* 常见布局 */
.full-width  { grid-column: 1 / -1; }  /* 占满 12列 */
.half        { grid-column: span 6; }  /* 占 6列 */
.third       { grid-column: span 4; }  /* 占 4列 */
.quarter     { grid-column: span 3; }  /* 占 3列 */
```

---

## 组件库

### 按钮 (Button)

#### 样式变体

```css
/* Primary Button */
.btn-primary {
  background-color: var(--color-primary-500);
  color: white;
  padding: var(--spacing-s) var(--spacing-m);
  border-radius: 6px;
  border: none;
  font-size: 14px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s ease;
}

.btn-primary:hover {
  background-color: var(--color-primary-700);
  box-shadow: 0 4px 12px rgba(33, 150, 243, 0.3);
}

.btn-primary:active {
  background-color: var(--color-primary-900);
  transform: scale(0.98);
}

/* Secondary Button */
.btn-secondary {
  background-color: transparent;
  color: var(--color-primary-500);
  border: 1px solid var(--color-primary-500);
  padding: var(--spacing-s) var(--spacing-m);
  border-radius: 6px;
  transition: all 0.2s ease;
}

.btn-secondary:hover {
  background-color: var(--color-primary-50);
  border-color: var(--color-primary-700);
  color: var(--color-primary-700);
}

/* Ghost Button */
.btn-ghost {
  background-color: transparent;
  color: var(--color-primary-500);
  border: none;
  padding: var(--spacing-s) var(--spacing-m);
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.btn-ghost:hover {
  background-color: var(--color-primary-50);
  border-radius: 6px;
}
```

#### 尺寸规范

```css
/* Small */
.btn-sm {
  padding: 4px 12px;
  font-size: 12px;
  border-radius: 4px;
}

/* Medium (默认) */
.btn {
  padding: 8px 16px;
  font-size: 14px;
  border-radius: 6px;
}

/* Large */
.btn-lg {
  padding: 12px 24px;
  font-size: 16px;
  border-radius: 8px;
  min-width: 120px;
}
```

### 卡片 (Card)

```css
.card {
  background-color: var(--color-neutral-white);
  border-radius: 8px;
  padding: var(--spacing-l);  /* 24px */
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.08);
  border: 1px solid rgba(0, 0, 0, 0.04);
  transition: box-shadow 0.2s ease, transform 0.2s ease;
}

.card:hover {
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);
  transform: translateY(-2px);
}

/* 卡片内部结构 */
.card__header {
  margin-bottom: var(--spacing-m);
  border-bottom: 1px solid var(--color-neutral-200);
  padding-bottom: var(--spacing-m);
}

.card__title {
  font-size: 18px;
  font-weight: 600;
  margin: 0;
  color: var(--color-neutral-900);
}

.card__content {
  font-size: 14px;
  color: var(--color-neutral-700);
  line-height: 1.6;
}

.card__footer {
  margin-top: var(--spacing-m);
  padding-top: var(--spacing-m);
  border-top: 1px solid var(--color-neutral-200);
  display: flex;
  justify-content: flex-end;
  gap: var(--spacing-m);
}
```

### 输入框 (Input)

```css
.input {
  width: 100%;
  padding: var(--spacing-s) var(--spacing-m);  /* 8px 16px */
  border: 1px solid var(--color-neutral-300);
  border-radius: 6px;
  font-size: 14px;
  font-family: inherit;
  transition: all 0.2s ease;
}

.input:hover {
  border-color: var(--color-neutral-400);
}

.input:focus {
  outline: none;
  border-color: var(--color-primary-500);
  box-shadow: 0 0 0 3px rgba(33, 150, 243, 0.1);
}

.input:disabled {
  background-color: var(--color-neutral-100);
  color: var(--color-neutral-500);
  cursor: not-allowed;
}

/* 错误状态 */
.input.error {
  border-color: var(--color-error-500);
}

.input.error:focus {
  box-shadow: 0 0 0 3px rgba(244, 67, 54, 0.1);
}
```

### 标签 (Label)

```css
.label {
  display: block;
  font-size: 12px;
  font-weight: 500;
  color: var(--color-neutral-700);
  margin-bottom: var(--spacing-xs);  /* 4px */
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

/* 必填标记 */
.label.required::after {
  content: '*';
  color: var(--color-error-500);
  margin-left: 2px;
}
```

### 消息提示 (Alert)

```css
.alert {
  padding: var(--spacing-m);
  border-radius: 6px;
  display: flex;
  align-items: flex-start;
  gap: var(--spacing-m);
  margin-bottom: var(--spacing-l);
}

/* Success Alert */
.alert.success {
  background-color: #C8E6C9;
  border-left: 4px solid #4CAF50;
  color: #2E7D32;
}

/* Warning Alert */
.alert.warning {
  background-color: #FFE0B2;
  border-left: 4px solid #FF9800;
  color: #E65100;
}

/* Error Alert */
.alert.error {
  background-color: #FFCDD2;
  border-left: 4px solid #F44336;
  color: #C62828;
}

/* Info Alert */
.alert.info {
  background-color: #B3E5FC;
  border-left: 4px solid #00BCD4;
  color: #00838F;
}
```

### 加载状态 (Loading)

```css
.spinner {
  width: 24px;
  height: 24px;
  border: 3px solid var(--color-neutral-200);
  border-top-color: var(--color-primary-500);
  border-radius: 50%;
  animation: spin 0.8s linear infinite;
}

@keyframes spin {
  to { transform: rotate(360deg); }
}

/* 加载骨架屏 */
.skeleton {
  background: linear-gradient(
    90deg,
    var(--color-neutral-200) 0%,
    var(--color-neutral-100) 50%,
    var(--color-neutral-200) 100%
  );
  background-size: 200% 100%;
  animation: loading 1.5s infinite;
}

@keyframes loading {
  0% { background-position: 200% 0; }
  100% { background-position: -200% 0; }
}
```

---

## 可访问性

### 色彩对比度 (Color Contrast)

所有文本和交互元素必须满足 **WCAG 2.1 AA** 标准：

```
等级要求:
AA 级:   4.5:1 (小文本)
AA 级:   3:1   (大文本、UI组件)
AAA 级:  7:1   (小文本)
AAA 级:  4.5:1 (大文本)
```

**检查工具**: WebAIM Contrast Checker, WAVE, Axe

### 焦点指示器 (Focus Indicator)

```css
/* 所有可交互元素都必须有明显焦点状态 */
:focus {
  outline: 2px solid var(--color-primary-500);
  outline-offset: 2px;
}

/* 或使用 focus-visible (推荐) */
:focus-visible {
  outline: 2px solid var(--color-primary-500);
  outline-offset: 2px;
  box-shadow: 0 0 0 4px rgba(33, 150, 243, 0.1);
}

/* 移除默认 outline 但只针对非焦点状态 */
:focus:not(:focus-visible) {
  outline: none;
}
```

### 键盘导航

```css
/* Tab 键顺序 */
元素应按逻辑顺序获得焦点，使用 tabindex:
- tabindex="0"   (纳入正常 tab 顺序)
- tabindex="-1"  (可通过 JS 获得焦点，但不在 tab 顺序中)
- 避免 tabindex > 0

/* 跳过链接 */
<a href="#main-content" class="skip-link">
  Skip to main content
</a>

.skip-link {
  position: absolute;
  left: -9999px;
  top: 0;
}

.skip-link:focus {
  left: 0;
  top: 0;
  background: var(--color-primary-500);
  color: white;
  padding: var(--spacing-m);
  z-index: 999;
}
```

### ARIA 标签

```html
<!-- 按钮 -->
<button aria-label="关闭菜单">×</button>

<!-- 表单字段 -->
<label for="email">邮箱：</label>
<input id="email" type="email" aria-describedby="email-help" />
<span id="email-help">请输入有效的邮箱地址</span>

<!-- 动态内容 -->
<div role="alert" aria-live="polite">
  操作已完成！
</div>

<!-- 禁用元素 -->
<button aria-disabled="true" disabled>
  不可用
</button>

<!-- 加载状态 -->
<div aria-busy="true" role="status">
  加载中...
</div>
```

### 文本替代 (Alternative Text)

```html
<!-- 图片 -->
<img 
  src="chart.png" 
  alt="2026年Q2销售额环比增长15%" 
/>

<!-- 图标按钮 -->
<button aria-label="添加新项目">
  <svg aria-hidden="true">...</svg>
</button>

<!-- 装饰性图片 -->
<img src="decoration.png" alt="" aria-hidden="true" />
```

---

## 交互规范

### 反馈时间 (Feedback Timing)

```
用户操作    响应时间      反馈方式
─────────────────────────────────────
点击按钮    < 100ms      立即高亮
页面加载    > 1s         显示进度条
表单验证    < 500ms      实时错误提示
数据加载    > 2s         骨架屏
操作完成    100-300ms    Toast 提示
```

### 过渡效果 (Transitions)

```css
/* 推荐的过渡时间 */
--transition-fast:   150ms ease
--transition-normal: 200ms ease
--transition-slow:   300ms ease

/* 使用场景 */
按钮悬停:   150ms
页面转换:   300ms
菜单打开:   200ms
加载动画:   连续
焦点状态:   150ms
```

### 动画原则

```css
/* 1. 使用 easing 函数提升体验 */
.btn {
  transition: all 200ms cubic-bezier(0.4, 0, 0.2, 1);
}

/* 2. 避免过度动画 (> 300ms) */
/* 3. 为运动障碍用户提供关闭选项 */
@media (prefers-reduced-motion: reduce) {
  * {
    animation-duration: 0.01ms !important;
    animation-iteration-count: 1 !important;
    transition-duration: 0.01ms !important;
  }
}

/* 4. 使用 GPU 加速的属性 */
transform, opacity  ✅ (使用)
width, height       ❌ (避免)
```

### 加载状态

```
操作流程:
初始状态 → 加载中 → 成功/失败 → 恢复

视觉反馈:
- 按钮禁用 + 加载图标
- 显示进度（可选）
- 成功/错误消息
- 2秒后自动恢复或用户操作
```

---

## 响应式设计

### 断点定义 (Breakpoints)

```css
/* Mobile First 方法 */
--breakpoint-xs: 320px   /* 小手机 */
--breakpoint-sm: 640px   /* 大手机 */
--breakpoint-md: 1024px  /* 平板 */
--breakpoint-lg: 1440px  /* 桌面 */
--breakpoint-xl: 1920px  /* 超宽屏 */

/* 媒体查询示例 */
/* 默认: 移动设备 (< 640px) */
.container {
  grid-template-columns: 1fr;
  padding: var(--spacing-m);
}

/* 平板及以上 */
@media (min-width: 640px) {
  .container {
    grid-template-columns: repeat(2, 1fr);
  }
}

/* 桌面 */
@media (min-width: 1024px) {
  .container {
    grid-template-columns: repeat(3, 1fr);
    max-width: 1440px;
  }
}
```

### 响应式字体 (Fluid Typography)

```css
/* 根据视口宽度缩放字体 */
.title {
  font-size: clamp(
    20px,      /* 最小值 */
    5vw,       /* 理想值 (视口宽度的5%) */
    48px       /* 最大值 */
  );
}

.body {
  font-size: clamp(12px, 2vw, 16px);
}
```

### 触摸友好性 (Touch Targets)

```css
/* 最小触摸区域: 44x44px */
.button {
  min-width: 44px;
  min-height: 44px;
  padding: 12px 16px;
}

/* 按钮间距 */
.button + .button {
  margin-left: var(--spacing-m);  /* 16px */
}

/* 移动设备上增加间距 */
@media (max-width: 640px) {
  .button {
    min-height: 48px;
    padding: 14px 20px;
  }
  
  .button + .button {
    margin-left: var(--spacing-l);  /* 24px */
  }
}
```

---

## 深色模式

### 色彩方案 (Color Scheme)

```css
/* 浅色模式 (默认) */
:root {
  color-scheme: light;
  
  /* 背景 */
  --bg-primary:   #FFFFFF;
  --bg-secondary: #FAFAFA;
  --bg-tertiary:  #F5F5F5;
  
  /* 文本 */
  --text-primary:   #212121;
  --text-secondary: #616161;
  --text-tertiary:  #9E9E9E;
}

/* 深色模式 */
@media (prefers-color-scheme: dark) {
  :root {
    color-scheme: dark;
    
    /* 背景 */
    --bg-primary:   #121212;
    --bg-secondary: #1E1E1E;
    --bg-tertiary:  #2A2A2A;
    
    /* 文本 */
    --text-primary:   #FFFFFF;
    --text-secondary: #B3B3B3;
    --text-tertiary:  #808080;
  }
}
```

### 深色模式卡片

```css
.card {
  background-color: var(--bg-primary);
  color: var(--text-primary);
  border: 1px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
}

@media (prefers-color-scheme: dark) {
  .card:hover {
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.5);
    background-color: var(--bg-secondary);
  }
}
```

### 图片处理

```css
/* 深色模式下降低图片亮度 */
@media (prefers-color-scheme: dark) {
  img {
    opacity: 0.9;
    filter: brightness(0.95);
  }
  
  /* 特定图片不调整 */
  .logo {
    filter: none;
  }
}
```

---

## 代码示例

### 完整的表单组件示例

```html
<form class="form">
  <div class="form-group">
    <label for="username" class="label">
      用户名
      <span class="label__required">*</span>
    </label>
    <input
      id="username"
      type="text"
      class="input"
      placeholder="输入用户名"
      aria-describedby="username-help"
      required
    />
    <small id="username-help" class="help-text">
      3-20个字符，只能包含字母、数字和下划线
    </small>
  </div>

  <div class="form-group">
    <label for="email" class="label">
      邮箱
      <span class="label__required">*</span>
    </label>
    <input
      id="email"
      type="email"
      class="input"
      placeholder="your@email.com"
      required
    />
  </div>

  <div class="form-group">
    <label for="password" class="label">
      密码
      <span class="label__required">*</span>
    </label>
    <input
      id="password"
      type="password"
      class="input"
      placeholder="至少8个字符"
      required
    />
    <small class="help-text">
      必须包含大小写字母和数字
    </small>
  </div>

  <div class="form-actions">
    <button type="submit" class="btn btn-primary">
      创建账户
    </button>
    <button type="reset" class="btn btn-secondary">
      清空
    </button>
  </div>
</form>

<style>
  .form {
    max-width: 400px;
    margin: 0 auto;
  }

  .form-group {
    margin-bottom: var(--spacing-l);
  }

  .label {
    display: block;
    margin-bottom: var(--spacing-xs);
    font-weight: 500;
    font-size: 12px;
    text-transform: uppercase;
    letter-spacing: 0.5px;
  }

  .label__required {
    color: var(--color-error-500);
  }

  .input {
    width: 100%;
    padding: var(--spacing-s) var(--spacing-m);
    border: 1px solid var(--color-neutral-300);
    border-radius: 6px;
    font-size: 14px;
    transition: all 200ms ease;
  }

  .input:focus {
    outline: none;
    border-color: var(--color-primary-500);
    box-shadow: 0 0 0 3px rgba(33, 150, 243, 0.1);
  }

  .help-text {
    display: block;
    margin-top: 4px;
    font-size: 12px;
    color: var(--text-secondary);
  }

  .form-actions {
    display: flex;
    gap: var(--spacing-m);
    margin-top: var(--spacing-2xl);
  }

  .btn {
    flex: 1;
    padding: var(--spacing-s) var(--spacing-m);
    border-radius: 6px;
    font-weight: 500;
    cursor: pointer;
    transition: all 200ms ease;
  }

  .btn-primary {
    background: var(--color-primary-500);
    color: white;
    border: none;
  }

  .btn-primary:hover {
    background: var(--color-primary-700);
    box-shadow: 0 4px 12px rgba(33, 150, 243, 0.3);
  }

  .btn-secondary {
    background: transparent;
    color: var(--color-primary-500);
    border: 1px solid var(--color-primary-500);
  }

  .btn-secondary:hover {
    background: var(--color-primary-50);
  }
</style>
```

### 卡片列表示例

```html
<div class="card-grid">
  <article class="card">
    <div class="card__header">
      <h2 class="card__title">项目标题</h2>
      <p class="card__meta">2026年7月10日</p>
    </div>
    <div class="card__content">
      这是一个示例卡片组件，包含标题、元数据和内容区域。
      支持响应式布局和深色模式。
    </div>
    <div class="card__footer">
      <button class="btn btn-sm btn-secondary">查看详情</button>
      <button class="btn btn-sm btn-primary">编辑</button>
    </div>
  </article>
  <!-- 更多卡片... -->
</div>

<style>
  .card-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
    gap: var(--spacing-l);
    padding: var(--spacing-2xl);
  }

  .card {
    background: var(--bg-primary);
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.08);
    transition: box-shadow 200ms ease, transform 200ms ease;
  }

  .card:hover {
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);
    transform: translateY(-2px);
  }

  .card__header {
    padding: var(--spacing-l);
    border-bottom: 1px solid var(--color-neutral-200);
  }

  .card__title {
    font-size: 18px;
    font-weight: 600;
    margin: 0 0 var(--spacing-xs) 0;
    color: var(--text-primary);
  }

  .card__meta {
    font-size: 12px;
    color: var(--text-tertiary);
    margin: 0;
  }

  .card__content {
    padding: var(--spacing-l);
    font-size: 14px;
    line-height: 1.6;
    color: var(--text-secondary);
  }

  .card__footer {
    padding: var(--spacing-m) var(--spacing-l);
    border-top: 1px solid var(--color-neutral-200);
    display: flex;
    justify-content: flex-end;
    gap: var(--spacing-m);
  }

  /* 响应式调整 */
  @media (max-width: 640px) {
    .card-grid {
      grid-template-columns: 1fr;
      gap: var(--spacing-m);
      padding: var(--spacing-m);
    }
  }
</style>
```

---

## 最佳实践 (Best Practices)

### DO ✅

- ✅ 使用定义好的间距和颜色变量
- ✅ 确保所有文本都满足 WCAG 对比度要求
- ✅ 为所有交互元素提供焦点状态
- ✅ 在移动设备上进行充分测试
- ✅ 使用语义化 HTML
- ✅ 提供加载和错误状态
- ✅ 尊重用户的动画偏好设置

### DON'T ❌

- ❌ 使用任意颜色和尺寸
- ❌ 创建无法获得焦点的可交互元素
- ❌ 仅依赖颜色传达信息
- ❌ 使用 < 44px 的触摸目标
- ❌ 创建超过 300ms 的强制动画
- ❌ 忽视深色模式适配
- ❌ 使用过时的 HTML 属性

---

## 版本控制

| 版本 | 日期 | 变更 |
|-----|------|------|
| 1.0.0 | 2026-07-10 | 初始版本，包含完整的设计系统规范 |

---

## 反馈与维护

- **问题报告**: 在项目仓库提交 Issue
- **建议改进**: 联系设计团队
- **更新周期**: 季度审查，根据需要更新

**最后更新**: 2026-07-10  
**维护者**: Under35 Design System Team
