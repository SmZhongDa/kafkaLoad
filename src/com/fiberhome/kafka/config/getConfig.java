p a c k a g e   c o m . f i b e r h o m e . k a f k a . c o n f i g ;  
  
 i m p o r t   j a v a . i o . F i l e R e a d e r ;  
 i m p o r t   j a v a . u t i l . A r r a y L i s t ;  
 i m p o r t   j a v a . u t i l . L i s t ;  
 i m p o r t   j a v a . u t i l . P r o p e r t i e s ;  
  
 i m p o r t   o r g . a p a c h e . k a f k a . c l i e n t s . p r o d u c e r . K a f k a P r o d u c e r ;  
 i m p o r t   o r g . s l f 4 j . L o g g e r ;  
 i m p o r t   o r g . s l f 4 j . L o g g e r F a c t o r y ;  
 i m p o r t   c o m . f i b e r h o m e . k a f k a . u t i l s . U t i l s ;  
  
  
  
  
 p u b l i c   c l a s s   g e t C o n f i g   {  
 	 p r i v a t e   s t a t i c   f i n a l   L o g g e r   l o g g e r   =   L o g g e r F a c t o r y . g e t L o g g e r ( g e t C o n f i g . c l a s s ) ;  
 	 	  
 	 / / �V"k)�?z�S 
 	 p r i v a t e   S t r i n g   _ f i l e _ p a t h ;  
 	 p r i v a t e   S t r i n g   _ f i l e n a m e _ r u l e ;  
 	 p r i v a t e   S t r i n g   _ p r o t o c o l ;  
 	 p r i v a t e   L i s t < S t r i n g >   _ p r o t o c o l _ l i s t   =   n e w   A r r a y L i s t < S t r i n g > ( ) ;  
 	 p r i v a t e   S t r i n g   _ t m p _ d i r ;  
 	 p r i v a t e   S t r i n g   _ b a d _ d i r ;  
 	  
 	 / / ��HrA]4d��
 	 p r i v a t e   S t r i n g   _ u r l ;  
 	 p r i v a t e   S t r i n g   _ u s e r ;  
 	 p r i v a t e   S t r i n g   _ p a s s w o r d ;  
 	  
 	 / / k a f k a  
 	 p r i v a t e   S t r i n g   _ k a f k a _ t o p i c ;  
 	 p r i v a t e   i n t   _ n u m ;  
 	 p r i v a t e   i n t   _ k a f k a _ p o r t   =   9 0 9 2 ;  
 	 p r i v a t e   i n t   _ z k _ p o r t   =   2 1 8 1 ;  
 	 p r i v a t e   S t r i n g   _ j s o n _ k e y _ t a b l e ;  
 	 p r i v a t e   S t r i n g   _ j s o n _ k e y _ p a r t i o n ;  
 	 p r i v a t e   S t r i n g   _ j s o n _ k e y _ d a t a ;  
 	 p r i v a t e   S t r i n g   _ k a f k a _ i p ;    
 	 p r i v a t e   L i s t < S t r i n g >   _ z k _ i p _ l i s t   =   n e w   A r r a y L i s t < S t r i n g > ( ) ;  
 	 p r i v a t e   S t r i n g   _ k a f k a _ g r o u p ;  
 	  
 	 p u b l i c   S t r i n g   g e t b a d _ d i r ( ) {  
 	 	 r e t u r n   t h i s . _ b a d _ d i r ;  
 	 }  
 	  
 	 p u b l i c   S t r i n g   g e t k a f k a _ g r o u p ( ) {  
 	 	 r e t u r n   t h i s . _ k a f k a _ g r o u p ;  
 	 }  
 	  
 	  
 	 p u b l i c   S t r i n g   g e t k a f k a _ t o p i c ( ) {  
 	 	 r e t u r n   t h i s . _ k a f k a _ t o p i c ;  
 	 }  
 	  
 	  
 	 p u b l i c   S t r i n g   g e t T M P _ D I R ( ) {  
 	 	 r e t u r n   t h i s . _ t m p _ d i r ;  
 	 }  
 	  
 	 p u b l i c   S t r i n g   g e t F I L E N A M E _ R U L E ( ) {  
 	 	 r e t u r n   t h i s . _ f i l e n a m e _ r u l e ;  
 	 }  
 	  
 	  
 	 p u b l i c   L i s t < S t r i n g >   g e t _ p r o t o c o l _ l i s t ( )   {  
 	 	 r e t u r n   _ p r o t o c o l _ l i s t ;  
 	 }  
  
  
 	  
 	 p u b l i c   S t r i n g   g e t F i l e _ p a t h ( )   {  
 	 	 r e t u r n   _ f i l e _ p a t h ;  
 	 }  
  
  
 	 p u b l i c   S t r i n g   g e t _ u r l ( )   {  
 	 	 r e t u r n   _ u r l ;  
 	 }  
  
  
  
 	 p u b l i c   S t r i n g   g e t _ u s e r ( )   {  
 	 	 r e t u r n   _ u s e r ;  
 	 }  
  
  
  
 	 p u b l i c   S t r i n g   g e t _ p a s s w o r d ( )   {  
 	 	 r e t u r n   _ p a s s w o r d ;  
 	 }  
  
  
 	 p u b l i c   i n t   g e t _ k a f k a _ p o r t ( )   {  
 	 	 r e t u r n   _ k a f k a _ p o r t ;  
 	 }  
  
  
  
 	 p u b l i c   v o i d   s e t _ k a f k a _ p o r t ( i n t   _ k a f k a _ p o r t )   {  
 	 	 t h i s . _ k a f k a _ p o r t   =   _ k a f k a _ p o r t ;  
 	 }  
  
  
  
 	 p u b l i c   L i s t < S t r i n g >   g e t _ z k _ i p _ l i s t ( )   {  
 	 	 r e t u r n   _ z k _ i p _ l i s t ;  
 	 }  
  
  
  
 	 p u b l i c   i n t   g e t _ z k _ p o r t ( )   {  
 	 	 r e t u r n   _ z k _ p o r t ;  
 	 }  
  
  
 	 p u b l i c   S t r i n g   g e t _ j s o n _ k e y _ t a b l e ( )   {  
 	 	 r e t u r n   _ j s o n _ k e y _ t a b l e ;  
 	 }  
  
  
  
 	 p u b l i c   S t r i n g   g e t _ j s o n _ k e y _ p a r t i o n ( )   {  
 	 	 r e t u r n   _ j s o n _ k e y _ p a r t i o n ;  
 	 }  
  
  
  
  
 	 p u b l i c   S t r i n g   g e t _ j s o n _ k e y _ d a t a ( )   {  
 	 	 r e t u r n   _ j s o n _ k e y _ d a t a ;  
 	 }  
  
  
 	 p u b l i c     i n t   g e t _ n u m ( )   {  
 	 	 r e t u r n   _ n u m ;  
 	 }  
  
  
 	 p u b l i c   s t a t i c   g e t C o n f i g   g e t _ i n s t a n c e ( )   {  
 	 	 r e t u r n   _ i n s t a n c e ;  
 	 }  
  
  
  
  
 	 p u b l i c   S t r i n g   g e t _ f i l e _ p a t h ( )   {  
 	 	 r e t u r n   _ f i l e _ p a t h ;  
 	 }  
  
  
 	  
 	  
 	 p r i v a t e   s t a t i c   g e t C o n f i g   _ i n s t a n c e   =   n e w   g e t C o n f i g ( ) ;  
 	 p u b l i c   s t a t i c   g e t C o n f i g   g e t I n s t a n c e ( ) {  
 	 	 r e t u r n   _ i n s t a n c e ;  
 	 }  
 	  
 	 p u b l i c   K a f k a P r o d u c e r < S t r i n g ,   S t r i n g >   g e t K a f k a P r o d u c e r ( )  
 	 {  
 	 	 P r o p e r t i e s   p r o p e r   =   n e w   P r o p e r t i e s ( ) ;  
 	 	 p r o p e r . p u t ( " b o o t s t r a p . s e r v e r s " ,   t h i s . _ k a f k a _ i p ) ;  
 	 	 p r o p e r . p u t ( " k e y . s e r i a l i z e r " ,   " o r g . a p a c h e . k a f k a . c o m m o n . s e r i a l i z a t i o n . S t r i n g S e r i a l i z e r " ) ;  
 	 	 p r o p e r . p u t ( " v a l u e . s e r i a l i z e r " ,   " o r g . a p a c h e . k a f k a . c o m m o n . s e r i a l i z a t i o n . S t r i n g S e r i a l i z e r " ) ; 	 	    
 	 	 p r o p e r . p u t ( " c o m p r e s s i o n . t y p e " ,   " n o n e " ) ;  
 	 	 p r o p e r . p u t ( " l i n g e r . m s " ,   " 0 " ) ;  
 	 	 p r o p e r . p u t ( " a c k s " ,   " a l l " ) ;  
 	 	 p r o p e r . p u t ( " r e t r i e s " ,   3 0 ) ;  
 	 	 p r o p e r . p u t ( " r e c o n n e c t . b a c k o f f . m s " ,   2 0 0 0 0 ) ;  
 	 	 p r o p e r . p u t ( " r e t r y . b a c k o f f . m s " ,   2 0 0 0 0 ) ;  
 	 	 p r o p e r . p u t ( " b a t c h . s i z e " ,   1 0 0 ) ;  
  
 	 	 r e t u r n   n e w   K a f k a P r o d u c e r < S t r i n g ,   S t r i n g > ( p r o p e r ) ;  
 	 }  
 	  
 	 p u b l i c   v o i d   l o a d ( S t r i n g   m a i n c o n f , S t r i n g   k a f k a c o n f , S t r i n g   d a t a b a s e c o n f ) {  
 	 	 l o g g e r . i n f o ( " [ s t a r t ]   c o n f i g   l o a d . " ) ;  
 	 	 i n i t M a i n C o n f i g ( m a i n c o n f ) ;  
 	 	 i n i t K a f k a C o n f i g ( k a f k a c o n f ) ;  
 	 	 i n i t D a t a b a s e C o n f i g ( d a t a b a s e c o n f ) ;  
 	 }  
 	  
 	  
 	 p u b l i c   v o i d   i n i t M a i n C o n f i g ( S t r i n g   c o n f _ f i l e ) {  
 	 	 t r y {  
 	 	 	 l o g g e r . d e b u g ( " l o a d   i n i t M a i n C o n f i g : "   +   c o n f _ f i l e ) ;  
 	 	 	 P r o p e r t i e s   p r o p e r t i e s   =   n e w   P r o p e r t i e s ( ) ;  
 	 	 	 F i l e R e a d e r   r e a d e r   =   n e w   F i l e R e a d e r ( c o n f _ f i l e ) ;  
 	 	 	 p r o p e r t i e s . l o a d ( r e a d e r ) ;  
 	 	 	 r e a d e r . c l o s e ( ) ;  
  
 	 	 	 t h i s . _ f i l e _ p a t h   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " F I L E _ P A T H " ) ;  
 	 	 	 t h i s . _ f i l e n a m e _ r u l e   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " F I L E N A M E _ R U L E " ) ;  
 	 	 	 t h i s . _ p r o t o c o l   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " P R O T O C O L " ) ;  
 	 	 	 S t r i n g [ ]   p r o t o c o l   =   _ p r o t o c o l . s p l i t ( " , " ) ;  
 	 	 	 f o r ( i n t   i   =   0 ; i   <   p r o t o c o l . l e n g t h ; i + + ) {  
 	 	 	 	 t h i s . _ p r o t o c o l _ l i s t . a d d ( p r o t o c o l [ i ] ) ;  
 	 	 	 	 l o g g e r . d e b u g ( p r o t o c o l [ i ] ) ;  
 	 	 	 } 	  
 	 	 	 t h i s . _ t m p _ d i r   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " T M P _ D I R " ) ;  
 	 	 	 t h i s . _ b a d _ d i r   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " B A D _ D I R " ) ;  
 	 	 	 U t i l s . c r e a t e D i r ( _ t m p _ d i r , _ b a d _ d i r ) ;  
 	 	 	  
 	 	 }  
 	 	 c a t c h ( E x c e p t i o n   e ) {  
 	 	 	 l o g g e r . e r r o r ( " l o a d   M a i n c o n f i g   f a i l e d .   - - "   +   e . g e t M e s s a g e ( ) , e ) ;  
 	 	 	 S y s t e m . e x i t ( - 1 ) ;  
 	 	 }  
 	 	  
 	 }  
 	  
  
 	  
 	  
 	 p u b l i c   v o i d   i n i t K a f k a C o n f i g ( S t r i n g   c o n f _ f i l e ) {  
 	 	 t r y {  
 	 	 	 P r o p e r t i e s   p r o p e r t i e s   =   n e w   P r o p e r t i e s ( ) ;  
 	 	 	 F i l e R e a d e r   r e a d e r   =   n e w   F i l e R e a d e r ( c o n f _ f i l e ) ;  
 	 	 	 p r o p e r t i e s . l o a d ( r e a d e r ) ;  
 	 	 	 r e a d e r . c l o s e ( ) ;  
 	 	 	 r e a d e r   =   n u l l ;  
 	 	 	  
 	 	 	 t h i s . _ k a f k a _ i p   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " K A F K A _ I P " ) ;  
 	 	 	 t h i s . _ z k _ p o r t   =   I n t e g e r . p a r s e I n t ( U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " Z K _ P O R T " ) ) ;  
 	 	 	 t h i s . _ n u m   =   I n t e g e r . p a r s e I n t ( U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " K A F K A _ S E N D E R _ N U M " ) ) ;  
 	 	 	 t h i s . _ j s o n _ k e y _ t a b l e   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " J S O N _ K E Y _ T A B L E " ) ;  
 	 	 	 t h i s . _ j s o n _ k e y _ p a r t i o n   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " J S O N _ K E Y _ P A R T I O N " ) ;  
 	 	 	 t h i s . _ j s o n _ k e y _ d a t a   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " J S O N _ K E Y _ D A T A " ) ;  
 	 	 	 t h i s . _ k a f k a _ t o p i c   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " K A F K A _ T O P I C " ) ;  
 	 	 	 t h i s . _ k a f k a _ g r o u p   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " K A F K A _ G R O U P " ) ;  
 	 	 	  
 	 	 }  
 	 	 c a t c h ( E x c e p t i o n   e ) {  
 	 	 	 l o g g e r . e r r o r ( " l o a d   K a f k a c o n f i g   f a i l e d .   "   +   e ) ;  
 	 	 	 S y s t e m . e x i t ( - 1 ) ;  
 	 	 }  
 	 	  
 	 }  
 	  
 	 p u b l i c   v o i d   i n i t D a t a b a s e C o n f i g ( S t r i n g   c o n f _ f i l e ) {  
 	 	 t r y {  
 	 	 	 P r o p e r t i e s   p r o p e r t i e s   =   n e w   P r o p e r t i e s ( ) ;  
 	 	 	 F i l e R e a d e r   r e a d e r   =   n e w   F i l e R e a d e r ( c o n f _ f i l e ) ;  
 	 	 	 p r o p e r t i e s . l o a d ( r e a d e r ) ;  
 	 	 	 r e a d e r . c l o s e ( ) ;  
 	 	 	 t h i s . _ u r l   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " U R L " ) ;  
 	 	 	 t h i s . _ u s e r   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " U S E R N A M E " ) ;  
 	 	 	 t h i s . _ p a s s w o r d   =   U t i l s . g e t N o t N u l l C o n f V a l u e ( p r o p e r t i e s ,   " P A S S W O R D " ) ;  
 	 	 }  
 	 	 c a t c h ( E x c e p t i o n   e ) {  
 	 	 	 l o g g e r . e r r o r ( " l o a d   D a t a b a s e c o n f i g   f a i l e d . "   +   e ) ;  
 	 	 	 S y s t e m . e x i t ( - 1 ) ;  
 	 	 }  
 	 	  
 	 	 l o g g e r . i n f o ( " [ c o m p l e t e ]   c o n f i g   l o a d   s u c c e s s f u l l y . " ) ;  
 	 	  
 	 }  
 	  
 	  
 / / 	 p u b l i c   S t r i n g   t o S t r i n g ( )   {  
 / / 	 	 S t r i n g B u i l d e r   s b   =   n e w   S t r i n g B u i l d e r ( ) ;  
 / / 	 	 s b . a p p e n d ( " [   d a t a P a t h   :   " ) ;  
 / / 	 	 s b . a p p e n d ( d a t a P a t h ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   i n d e x P a t h   :   " ) ;  
 / / 	 	 s b . a p p e n d ( i n d e x P a t h ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   u r l   :   " ) ;  
 / / 	 	 s b . a p p e n d ( u r l ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   u s e r   :   " ) ;  
 / / 	 	 s b . a p p e n d ( u s e r ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   p a s s w d   :   " ) ;  
 / / 	 	 s b . a p p e n d ( p a s s w d ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   d a t a S o u r c e   :   " ) ;  
 / / 	 	 s b . a p p e n d ( d a t a S o u r c e ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   W A L P a t h   :   " ) ;  
 / / 	 	 s b . a p p e n d ( W A L P a t h ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   i n t e r v a l   :   " ) ;  
 / / 	 	 s b . a p p e n d ( i n t e r v a l ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   p e r i o d   :   " ) ;  
 / / 	 	 s b . a p p e n d ( p e r i o d ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   k e e p F i l e   :   " ) ;  
 / / 	 	 s b . a p p e n d ( k e e p F i l e ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   r e l o a d e r   :   " ) ;  
 / / 	 	 s b . a p p e n d ( r e l o a d e r ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   r e l e a s e   :   " ) ;  
 / / 	 	 s b . a p p e n d ( r e l e a s e ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   t a x o R e l o a d e r   :   " ) ;  
 / / 	 	 s b . a p p e n d ( t a x o R e l o a d e r ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   t a x o R e l e a s e   :   " ) ;  
 / / 	 	 s b . a p p e n d ( t a x o R e l e a s e ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   p o r t   :   " ) ;  
 / / 	 	 s b . a p p e n d ( p o r t ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   d i m e n s i o n   :   " ) ;  
 / / 	 	 s b . a p p e n d ( d i m e n s i o n ) ;  
 / / 	 	 s b . a p p e n d ( "   ,   d i m M a p   :   " ) ;  
 / / 	 	 s b . a p p e n d ( D I M M A P ) ;  
 / / 	 	 s b . a p p e n d ( "   ] " ) ;  
 / / 	 	 r e t u r n   s b . t o S t r i n g ( ) ;  
 / / 	 }  
 	  
 }  
 