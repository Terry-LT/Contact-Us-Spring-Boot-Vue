<template>
  <AboutPage class="mt-5" />
  <WhyChooseUsVue class="mt-5" />
  <ContactUsPageVue class="mt-5" />
</template>

<script>
import AboutPage from '@/components/AboutPage.vue';
import WhyChooseUsVue from '../components/WhyChooseUs.vue';
import ContactUsPageVue from '../components/ContactUsPage.vue';
// @ is an alias to /src
export default {
  name: 'HomeView',
  components:{
    AboutPage,
    WhyChooseUsVue,
    ContactUsPageVue
  }
}
</script>
