(() => {
  // Mobile nav toggle
  const toggle = document.querySelector('[data-nav-toggle]');
  const links = document.querySelector('[data-nav-links]');
  if (toggle && links) {
    toggle.addEventListener('click', () => {
      const isOpen = links.classList.toggle('is-open');
      toggle.setAttribute('aria-expanded', String(isOpen));
    });
  }

  // Contact form demo submit
  const form = document.querySelector('[data-contact-form]');
  if (form) {
    form.addEventListener('submit', (e) => {
      e.preventDefault();
      const note = form.querySelector('[data-form-note]');
      if (!note) return;

      note.hidden = false;
      note.textContent = 'Aitäh! See on demo. Kui tahad päris saatmist, lisame selle eraldi.';
      form.reset();
    });
  }
})();
